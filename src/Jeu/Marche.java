package Jeu;

import java.util.*;

public class Marche {
    private String nom; /**< Market's name */
    private int nombreActions; /**< Number of stocks in the market*/
    public Map<Action, Integer>  actions = new HashMap<Action, Integer>(); /**< stocks in the market and their quantities */
    public Map<Option, Integer>  options = new HashMap<Option, Integer>(); /**< put/call in the market and their quantities */
    private double[] cours; /**< stocks ' price at current time*/
    private double[] prixOption; /**put/call price at current tima*/

    // CONSTRUCTOR //

    /**
     * \fn Jeu.Marche(String nom, int curround ,int nombreActions)
     * \brief Constructor of a market
     *
     * \param String nom : Market's name
     * \param int nombreActions : The number of actions in the market
     * \param double cours : stocks's price at current time
     * \throws Exception in ......
     */
    public Marche(String nom, int nombreActions, List<Action> actions, List<Option> options)throws Exception{
        //int i = 0;

        Random randQ = new Random();
        for(int j=0; j< nombreActions ;j++ ){
            this.actions.put(actions.get(j), randQ.nextInt(500) +500);

        }
        this.nombreActions = nombreActions;
        this.nom = nom;

    }

    /**
     * create random market with nbActions with nbtour
     * @param nbActions
     * @param nbtour
     * @return
     */
    public static Marche randomMarket(int nbActions, int nbtour) throws Exception {
        List<Action> actions = new LinkedList<Action>();
        List<Option> options = new LinkedList<Option>();
        Action randAction;
        for (int i = 0; i < nbActions; i++) {
            randAction =Action.randomAction(i+100,nbtour);
            actions.add(randAction);

        }
        Marche m = new Marche("",nbActions,actions,options);
        return m;
    }

    //GETTER

    public String getNom() {
        return nom;
    }

    //METHODS

    /**
     *
     * @param action
     * @return the quantite of the stock in the market
     */
    public int getQAction(Action action) {
        return actions.get(action);
    }

    public void setQAction(Action action,int quantite){
        actions.replace(action,quantite);
    }


    public Action getAction(int IdAction) throws Exception {
        for (Action action : actions.keySet()) {
            if (action.getId() == IdAction) {
                return action;
            }
        }
        throw new Exception("Cette action n'existe pas");
    }

    @Override
    public String toString() {
        String s = "\n\t Ce marché" + nom +" contient "+  nombreActions + " actions\n";
        for (Action i : actions.keySet()){
           /// s += toString(i);
        }
        return s;
    }

    /**jumb to t+1
     * and update the price of the assets nd options
     * @param t
     */
    public void updateMarche(int t){
        for (Action action:actions.keySet()) {
            action.updateActif(t);
        }

    }



}
