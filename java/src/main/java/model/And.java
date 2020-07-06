package model;

import java.util.List;

/**
 * Trieda s implementáciou pravidla pre parser: AND (logická spojka).
 */
public class And implements Condition {
    private int isNeg;
    private And value1;
    private And value2;
    private List<Condition> conditions;
    private boolean hasParenthesis;
    private int status = 0;

    /**
     * Prázdny konštruktor na vytvorenie inštancie objektu.
     */
    public And() {

    }

    /**
     * Konštruktor, ktorý spracováva vstupné údaje pre použitie v ïalších metódach objektu.
     * @param isNeg predstavuje poèet zadaných negácií.
     * @param value1 hodnota na ¾avej strane v príkaze typu and.
     * @param value2 hodnota na pravej strane v príkaze typu and.
     * @param hasParenthesis reprezentuje zátvorky v príkaze, true ak boli zadané, inak false.
     */
    public And(int isNeg, And value1, And value2, boolean hasParenthesis) {
        this.isNeg = isNeg;
        this.value1 = value1;
        this.value2 = value2;
        this.hasParenthesis = hasParenthesis;
    }

    /**
     * @return poèet zadaných negácií.
     */
    @Override
    public int isNeg() {
        return isNeg;
    }


    /**
     * @return true, ak uz su vypísané všetky kroky riešenia.
     */
    @Override
    public boolean isDone() {
        return status == 1 && value1.isDone() && value2.isDone();
    }

    /**
     * @return výpis jednotlivých krokov.
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
     * @return výpis pôvodného zadania vstupného príkazu.
     * Využíva sa pri vypísaní prvého kroku generovania inštrukcií.
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
     * @param value1 predstavuje prvú hodnotu v príkaze typu and.
     */
    public void setValue1(And value1) {
        this.value1 = value1;
    }

//    public And getValue2() {
//        return value2;
//    }

    /**
     * @param value2 predstavuje druhú hodnotu v príkaze typu and.
     */
    public void setValue2(And value2) {
        this.value2 = value2;
    }

//    public boolean isHasParenthesis() {
//        return hasParenthesis;
//    }

    /**
     * Set metóda na nastavenie toho, že príkaz obsahuje alebo neobsahuje zátvorky.
     * @param hasParenthesis predstavuje zátvorky.
     */
    public void setHasParenthesis(boolean hasParenthesis) {
        this.hasParenthesis = hasParenthesis;
    }

//    public int getIsNeg() {
//        return isNeg;
//    }

    /**
     * @param isNeg predstavuje poèet zadaných negácií.
     */
    public void setIsNeg(int isNeg) {
        this.isNeg = isNeg;
    }
}
