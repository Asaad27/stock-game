package Jeu;



import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Jeu {
    private Map<String, Utilisateur> Players;/*** players key =mail*/
    private Utilisateur currentPlay;
    public Jeu() {
        Players = new HashMap<String, Utilisateur>();
    }

    /**
     * verify if the account name is already used
     * @param accN account name chosed by player
     * @return
     */
    public boolean accountExists(String accN){
       return Players.containsKey(accN);
    }

    /**
     * creat a player with the name nd pword
     * @param name
     * @param pword
     */
    public void addAccount(String name,String pword){
        Utilisateur player = new Utilisateur(name,pword,null);
        Players.put(name,player);
    }


    /**
     * verify that the account exists and check password
     * @param name
     * @param pword
     * @return
     */
    public boolean logIn(String name, String pword){
        Utilisateur player = Players.get(name);
        if (player == null){
            return false;
        }
        if(player.getPasseword().equals(pword)){
            currentPlay = player;
            return true;
        }
        return false;
    }

    /**
     * create Partie with the following args
     * @param nbp
     * @param nbA
     * @param nbturns
     */
    public void creatSim(int nbp,int nbA, int nbturns)  {
        List<Integer> l = new LinkedList<Integer>();
        l.add(currentPlay.getId());
        for (int i = 0; i < nbp; i++) {
            l.add(i+500);
        }
        Partie partie = null;
        try {
            partie = new Partie(l,nbA,nbturns);
        } catch (Exception e) {
            e.printStackTrace();
        }
        currentPlay.setPartie(partie);
    }

    /**
     * verify if the player was in a simu
     * @return
     */
    public boolean inSimu(){
        return this.currentPlay.getPartie() != null;
    }

    /**
     * go next round
     */
    public void nextRound(){
        currentPlay.getPartie().nextRound();
    }

    public int getRound(){
        return currentPlay.getPartie().getRound();
    }


    public Object[][] getTableAssets(){
        return currentPlay.getPartie().marketdata();
    }

    public Object[] getTableColumns(){
        Object[] columns = {"id", "Entreprise", "Prix","Qte"};
        return columns;
    }

    public String getCash(){
        return ""+currentPlay.getPartie().getPortefeille(currentPlay.getId()).getCash();
    }


    public Object[][] getTableowned() {
        PorteFeuille p = currentPlay.getPartie().getPortefeille(currentPlay.getId());
        int t = p.getActions().size();
        Object[][] table = new Object[t][4];
        int i =0;
        for (Action a: p.getActions()
             ) {
            table[i][0] = a.getId();
            table[i][1] = a.getNomEntreprise();
            table[i][2] = a.getPrix();
            table[i][3] = p.getquantiteAction(a);
            i++;

        }
        return table;
    }
    public  Object[][] getTableHistory(){
        LinkedList<String> history = currentPlay.getHistorique().ConsulterHistorique();
        Object[][] table = new Object[history.size()][1];
        int i =0;
        for (String a: history
        ) {
            table[i][0] = a;
            i++;
        }
        return table;
    }
    public Object[] getHistColumn(){
        Object[] columns = {"History"};
        return columns;
    }



    public String getmaxround() {
        return ""+currentPlay.getPartie().getmaxRounds();
    }

    public void Acheter(int id,int qty) throws Exception {
        Action b = currentPlay.getPartie().marche.getAction(id);
        currentPlay.acheterAction(b,qty);
    }

    public void Vendre(int id, int qty) throws Exception {
        Action b = currentPlay.getPartie().marche.getAction(id);
        currentPlay.vendreAction(b,qty);
    }

    public Object[][] getFav(){
        List<Action> l = currentPlay.getActionsurveille();
        int s = l.size();
        Object[][] table = new Object[s][4];
        int i =0;
        for (Action a:l) {
            table[i][1] = a.getId();
            table[i][2] = a.getNomEntreprise();
            table[i][0] = i+1;
            table[i][3] = a.getPrix();
            i++;

        }
        return table;
    }

    public Object[] getFavColumns(){
        Object[] columns = {"Num","id Asset", "Entreprise", "Prix"};
        return columns;
    }

    public void addFav(int id){
        currentPlay.addFavorite(id);
    }

    public void removeFav(int pos){
        currentPlay.removeFavorite(pos);
    }


}