package model;

import java.util.List;

/**
 * Trieda s implement�ciou pravidla pre parser: AND (logick� spojka).
 */
public class And implements Condition {
    private int isNeg;
    private And value1;
    private And value2;
    private List<Condition> conditions;
    private boolean hasParenthesis;
    private int status = 0;

    /**
     * Pr�zdny kon�truktor na vytvorenie in�tancie objektu.
     */
    public And() {

    }

    /**
     * Kon�truktor, ktor� spracov�va vstupn� �daje pre pou�itie v �al��ch met�dach objektu.
     * @param isNeg predstavuje po�et zadan�ch neg�ci�.
     * @param value1 hodnota na �avej strane v pr�kaze typu and.
     * @param value2 hodnota na pravej strane v pr�kaze typu and.
     * @param hasParenthesis reprezentuje z�tvorky v pr�kaze, true ak boli zadan�, inak false.
     */
    public And(int isNeg, And value1, And value2, boolean hasParenthesis) {
        this.isNeg = isNeg;
        this.value1 = value1;
        this.value2 = value2;
        this.hasParenthesis = hasParenthesis;
    }

    /**
     * @return po�et zadan�ch neg�ci�.
     */
    @Override
    public int isNeg() {
        return isNeg;
    }


    /**
     * @return true, ak uz su vyp�san� v�etky kroky rie�enia.
     */
    @Override
    public boolean isDone() {
        return status == 1 && value1.isDone() && value2.isDone();
    }

    /**
     * @return v�pis jednotliv�ch krokov.
     */
    @Override
    public String print() {
        switch (status) {
            case 0:
                status++;
                StringBuilder sb = new StringBuilder();
                sb.append("TB[");
                for(int i=0; i<isNeg; i++){
                    sb.append("!(");
                }
                sb.append(toString()).append("]");
//                return "TB[" + toString() + "]";
            case 1:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(value2.print()).append(":").append(value1.print()).append(":AND");
                for(int i=0; i<isNeg; i++){
                    sb2.append(":NEG");
                }
                return sb2.toString();
//                return conditions.get(1).print() + ":" + conditions.get(0).print() + ":AND";

        }
        return toString();
    }

    /**
     * @return v�pis p�vodn�ho zadania vstupn�ho pr�kazu.
     * Vyu��va sa pri vyp�san� prv�ho kroku generovania in�trukci�.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(isNeg > 0){
            for(int i=0; i<isNeg; i++){
                sb.append("!(");
            }
        }
        sb.append("(").append(value1).append("&&").append(value2).append(")");
        return sb.toString();
    }

//    public And getValue1() {
//        return value1;
//    }

    /**
     * @param value1 predstavuje prv� hodnotu v pr�kaze typu and.
     */
    public void setValue1(And value1) {
        this.value1 = value1;
    }

//    public And getValue2() {
//        return value2;
//    }

    /**
     * @param value2 predstavuje druh� hodnotu v pr�kaze typu and.
     */
    public void setValue2(And value2) {
        this.value2 = value2;
    }

//    public boolean isHasParenthesis() {
//        return hasParenthesis;
//    }

    /**
     * Set met�da na nastavenie toho, �e pr�kaz obsahuje alebo neobsahuje z�tvorky.
     * @param hasParenthesis predstavuje z�tvorky.
     */
    public void setHasParenthesis(boolean hasParenthesis) {
        this.hasParenthesis = hasParenthesis;
    }

//    public int getIsNeg() {
//        return isNeg;
//    }

    /**
     * @param isNeg predstavuje po�et zadan�ch neg�ci�.
     */
    public void setIsNeg(int isNeg) {
        this.isNeg = isNeg;
    }
}
