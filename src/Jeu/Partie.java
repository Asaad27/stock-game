package Jeu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Partie {
    private Utilisateur[] classement;
    public Marche marche;
    private int tourCourant; /**<current time  */
    private final int nbTour; /** nb of times leap*/
    private Map<Integer,PorteFeuille> porteFeuilles;/**Portfolios of the players of the Partie */


    /**
     *  when we start the partie starts we create the market, the asset, portfolios,histories ,favorites
     *      * of each player
     * @param playersID id of the players playing
     * @param nbActions nb actions in the market
     * @param nbtour nb of simulation tours
     */
    public Partie(List<Integer> playersID,int nbActions,int nbtour) throws Exception {


        /**creation virtuelle market with nbActions */
        this.marche= Marche.randomMarket(nbActions,nbtour);

        /** creation of portfolios ,historires and favoris*/
        porteFeuilles = new HashMap<Integer,PorteFeuille>();
        tourCourant = 0;
        for (int id:playersID) {
            porteFeuilles.put(id,new PorteFeuille());

        }
        nbTour = nbtour;
    }



    /**get the Portefeuille of the player with id
     * */

    public PorteFeuille getPortefeille(int id){
        return porteFeuilles.get(id);
    }




    public Utilisateur[] checkClassement(){
        return this.classement;
    }



    /**
     * \fn void nextLap()
     * \brief  Pass to the next round
     */
    public void nextRound(){
        tourCourant++;
        try{
            marche.updateMarche(tourCourant);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getRound(){
        return tourCourant;
    }

    public Object[][] marketdata(){
        int taille = marche.actions.size();
        Object[][] table = new Object[taille][4];
        int i = 0;
        for (Action a: marche.actions.keySet()) {
            table[i][0] = a.getId();
            table[i][1] = a.getNomEntreprise();
            table[i][2] = a.getPrix();
            table[i][3] = marche.getQAction(a);
            i++;
        }
        return table;
    }

    public int getmaxRounds() {
        return nbTour;
    }
}
