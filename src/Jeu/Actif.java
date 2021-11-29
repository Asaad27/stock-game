package Jeu;

public abstract class Actif {
    private double prix;
    public Actif(double prix){
        this.prix = prix;
    }

    public double getPrix() {
        return prix;
    }

    protected void setPrix(double prix) {
        this.prix = prix;
    }
    /**Update le cours des actif fe t --> t+1*/
    abstract void updateActif(int t);
}
