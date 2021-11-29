package Jeu;

import java.util.*;

public class PorteFeuille {
    private double cash; /**< User's Cash */
    private Map<Action, Integer> actionsDetenus ; /**< portfolio's actions*/
    private Map<Option, Integer> options; /**< portfolio's options*/


    public PorteFeuille(){
        this.cash = 100;
        this.actionsDetenus =  new HashMap<Action, Integer> ();
        this.options = new HashMap<Option, Integer>();
    }
    public double getCash(){
        return this.cash;
    }
    public void setCash(double cash){
        this.cash = cash;
    }
    public Set<Action> getActions(){
        return this.actionsDetenus.keySet();
    }
    public int getquantiteAction(Action action){
        return this.actionsDetenus.get(action);
    }

    public void addAction(Action action,int quantite){
        if(this.actionsDetenus.containsKey(action)){
            this.actionsDetenus.replace(action,this.actionsDetenus.get(action)+quantite);
        }
        else this.actionsDetenus.put(action,quantite);
    }
    public void removeAction(Action action,int quantite){
        if(this.actionsDetenus.get(action)>quantite){
            this.actionsDetenus.replace(action,this.actionsDetenus.get(action)-quantite);
        }
        else this.actionsDetenus.remove(action);
    }

}



