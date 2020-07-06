package model;

import app.Symbols;

/**
 * Trieda s implementáciou pravidla pre parser: BOOLEAN VALUE.
 */
public class BooleanValue extends And implements Condition, AssignmentValue {
//    private boolean isNeg;
    private int isNeg;
    private String varName;
//    private Value value;
    private int status;

    /**
     * Konštruktor, ktorý spracováva vstupné údaje pre použitie v ïalších metódach objektu.
     * @param isNeg predstavuje poèet zadaných negácií.
     * @param varName vkladá do konštruktora názov boolean premennej.
     */
    public BooleanValue(int isNeg, String varName) {
        this.isNeg = isNeg;
        this.varName = varName;
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
        return status == 1;
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
                sb.append("TB[").append(varName).append("]");
                for(int i=0; i<isNeg; i++){
                    sb.append(":NEG");
                }
                return sb.toString();
//                return "TB[" + varName + "]" + (isNeg ? ":NEG" : "");
            case 1:
                StringBuilder sb2 = new StringBuilder();
                if(varName.equals("true")){
                    sb2.append("TRUE");
                } else if(varName.equals("false")){
                    sb2.append("FALSE");
                } else {
                    sb2.append("FETCH-").append(varName);
                }
                for(int i=0; i<isNeg; i++){
                    sb2.append(":NEG");
                }
                return sb2.toString();
//                return (varName.equals("true")) ? "TRUE" : (varName.equals("false")) ? "FALSE" : "FETCH-" + varName + (isNeg ? ":NEG" : "");
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
        sb.append(varName);
        for(int i=0; i<isNeg; i++){
            sb.append(")");
        }
        return sb.toString();
//        return (isNeg ? "!" : "") + varName;
    }
}