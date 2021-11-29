package Jeu;

import java.util.function.ToDoubleBiFunction;

public class Option extends Actif {
    private final String type;
    private double exercice;
    private final Action associatedAction;
    private int date;

    public Option(double prix, String type, double exercice, Action associatedAction, int date){
        super(prix);
        this.type= type;
        this.exercice = exercice;
        this.associatedAction = associatedAction;
        this.date = date;

    }

    public static Option randomOption(Action action) {
        /**TODO
         * random option associeted with action
         */
        return new Option(100,"Call",2,action,5);
    }

    @Override
    public int hashCode() {
        return this.type.hashCode() + associatedAction.hashCode() + date;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Option){
            Option antherOption = (Option) obj;
            return type.equals(antherOption.type) && associatedAction.equals(antherOption.associatedAction)
                    && (date == antherOption.date);
        }
        return false;
    }

    public Action getAssociatedAction() {
        return associatedAction;
    }

    public double getExercice() {
        return exercice;
    }

    public void setExercice(double exercice) {
        this.exercice = exercice;
    }

    public String getType() {
        return type;
    }

    public int getDate() {
        return date;
    }

    /**
     * Update le cours des actif fe t --> t+1
     *
     * @param t
     */
    @Override
    void updateActif(int t) {

    }
}
