package Jeu;

import java.util.LinkedList;

public class Historique {

    private LinkedList<String> Operations;


    public Historique(){
        this.Operations = new LinkedList<String>();
    }
    public void AjouterOperation(String operation){
        this.Operations.add(operation);
    }
    public LinkedList<String> ConsulterHistorique(){
        return this.Operations;
    }


}
