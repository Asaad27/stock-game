package Jeu;

import java.util.LinkedList;
import java.util.Map;


public class Utilisateur {
    private String mail;/**< User's email*/
    private String passeword;/**<User's passeword*/
    static int nombreUtilisateur=0;/**<Number of Users options*/
    private int id;/**< User's ID*/
    private int classement;/**< User's ranking*/
    private Partie partie; /** the current game*/
    private Boolean dejaEmprunter;
    private static double seuilEmprunt;
    private LinkedList<Action> actionsurveille = new LinkedList<Action>();
    private Historique historique;/**History of the player of the Partie */

    /**
     * \fn Jeu.Utilisateur(String mail, String passeword)
     * \brief Constructor of a Utilisateur
     *
     * \param int ID : The ID of the user
     * \param String mail : The email of the user
     * \param String passeword :the passeword of the user
     */

    public Utilisateur(String mail,String passeword,Partie partie){
        this.mail = mail;
        this.passeword = passeword;
        this.id = nombreUtilisateur + 1;
        nombreUtilisateur++;
        this.partie = partie;
        this.dejaEmprunter= false;
        this.historique = new Historique();

    }

    //GETTER


    public Historique getHistorique() {
        return historique;
    }

    public LinkedList<Action> getActionsurveille() {
        return actionsurveille;
    }

    public int getId() {
        return id;
    }

    public int getClassement() {
        return classement;
    }

    //Methods

    /**
     * \fn void acheterActif(int IDAction, int quantite)
     * \brief Allow user to buy an asset
     *
     * \param int IdAction : The Id of the asset
     * \param quantite : The quantity to buy
     * \throws Exception : If the user doesn't have enough money or the quantity is asking
     * not available
     */
    public void acheterAction(Action action, int quantite) throws Exception{
        PorteFeuille portefeuille = partie.getPortefeille(id);
        int quantiteDispo = this.partie.marche.getQAction(action);
        if(quantiteDispo>=quantite){
            if(portefeuille.getCash()>= action.getPrix()* quantite){
                portefeuille.setCash(portefeuille.getCash() - action.getPrix()* quantite);
                portefeuille.addAction(action,quantite);
                this.partie.marche.setQAction(action,quantiteDispo - quantite);
                historique.AjouterOperation("You have bought " +quantite+" assets of  "+ action.getNomEntreprise() + " its ID is :"+action.getId() +" at t =  " + partie.getRound() );
                return;
            }
            throw new Exception(" operation d'achat impossible: pas assez de cash dans votre portefeuille ");
        }
        throw new Exception(" operation d'achat impossible: ce nombre d'action n'existe pas ");
    }
    /**
     * \fn void vendreActif(int IDAction, int quantite)
     * \brief Allow user to sell an asset
     *
     * \param int IdAction : the asset
     * \param quantite : The quantity to sell
     * \throws Exception : If the user doesn't have the quantity he want to sell
     */
    public void vendreAction(Action action, int quantite) throws Exception {
        PorteFeuille portefeuille = partie.getPortefeille(id);
        if(portefeuille.getquantiteAction(action)>= quantite){
            portefeuille.setCash(portefeuille.getCash() + action.getPrix()*quantite);
            portefeuille.removeAction(action,quantite);
            partie.marche.setQAction(action, partie.marche.getQAction(action) + quantite);
            historique.AjouterOperation("You have sold " +quantite+" assets of  "+ action.getNomEntreprise()
                    + "its ID is :"+action.getId() +" at t =  " + partie.getRound());
            return;
        }
        throw new Exception(" operation de vente impossible: vous n'avez pas cette quantite d'action ");


    }




    public void Emprunter(double somme) throws Exception {
        PorteFeuille portefeuille = partie.getPortefeille(id);
        if (!dejaEmprunter){
            if(somme< seuilEmprunt){
                portefeuille.setCash(portefeuille.getCash()+somme);
                dejaEmprunter = true;
            }
            throw new Exception("Impossible d'emprunter cette somme");
        }
        throw new Exception("Impossible d'emprunter plusieurs fois");
    }


    /**
     * \fn String afficheClassement()
     * \brief Show the rank of User
     *
     * \return String : The description
     */
    public String consulterClassement(){
        String s = null;
        int i=1;
        for (Utilisateur utilisateur :this.partie.checkClassement()){
            s +=utilisateur.id+"-";
        }
        return s;
    }


    /**
     * \fn String affichePortefeuille()
     * \brief Permit to describe the portfolio
     *
     * \return String : The description
     */
    public String affichePortefeuille(){
        PorteFeuille portefeuille = partie.getPortefeille(id);
        String s= "cash: "+portefeuille.getCash()+"-";
        for(Action action :portefeuille.getActions() ) {
            s += "vous avez" +portefeuille.getquantiteAction(action)+" de l'action de " +action.getNomEntreprise()+"-";
        }
        return s;
    }
    /**
     * \fn String toStringHistorique()
     * \brief Permit to describe the history
     *
     * \return String : The description
     */
    public String VoirHist(){
        String s = null;
        for(String operation : historique.ConsulterHistorique()){
            s+=operation+"-";
        }
        return s;
    }


    public void addFavorite(int id){

           Action action = null;
           try {
               action = partie.marche.getAction(id);
           } catch (Exception e) {
               e.printStackTrace();
           }
           actionsurveille.add(action);
    }

    public  void removeFavorite(int position){
        actionsurveille.remove(position-1);

    }

    public String getMail() {
        return mail;
    }

    public String getPasseword() {
        return passeword;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }


}
