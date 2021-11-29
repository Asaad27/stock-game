package Jeu;

import Modele.PontBrownien;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Action extends Actif{

    /**
     *
     */
    private final int id;
    private final String nomEntreprise;
    private final double[] cours;
    public Action(double prix,String nomEntreprise,int id,int nbTour){
        super(prix);
        this.nomEntreprise = nomEntreprise;
        this.id = id;
        PontBrownien W = new PontBrownien(nbTour, prix);
        cours = W.simuler();
    }


    /**
     * create random action
     *
     * @param i asset id
     * @param nbtour nb of simulation periods
     * @return
     */
    public static Action randomAction(int i, int nbtour) {
        Random rand = new Random();
        double prixS0 = rand.nextInt(50)+50;
        String nomentre = "Samsung";//random nouns todo
        return new Action(prixS0,nomentre,i,nbtour);
    }

    @Override
    public int hashCode() {
        return this.nomEntreprise.hashCode() + id*100;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Action){
            Action anotherAction = (Action) obj;
            return this.nomEntreprise.equals(anotherAction.nomEntreprise) && this.getId()==anotherAction.getId();
        }
        return false;
    }



    public int getId() {
        return id;
    }


    public String getNomEntreprise() {
        return nomEntreprise;
    }


    /**
     * Update le cours des actif fe t --> t+1
     */
    @Override
    void updateActif(int time) {
        this.setPrix(this.cours[time]);
    }
}
