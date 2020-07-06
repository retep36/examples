package model;

import app.Symbols;

/**
 * Trieda s implement�ciou pravidla pre parser: BOOLEAN VALUE.
 */
public class BooleanValue extends And implements Condition, AssignmentValue {
//    private boolean isNeg;
    private int isNeg;
    private String varName;
//    private Value value;
    private int status;

    /**
     * Kon�truktor, ktor� spracov�va vstupn� �daje pre pou�itie v �al��ch met�dach objektu.
     * @param isNeg predstavuje po�et zadan�ch neg�ci�.
     * @param varName vklad� do kon�truktora n�zov boolean premennej.
     */
    public BooleanValue(int isNeg, String varName) {
        this.isNeg = isNeg;
        this.varName = varName;
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
        return status == 1;
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
        sb.append(varName);
        for(int i=0; i<isNeg; i++){
            sb.append(")");
        }
        return sb.toString();
//        return (isNeg ? "!" : "") + varName;
    }
}