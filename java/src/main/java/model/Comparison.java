package model;

import java.util.List;

/**
 * Trieda s implement�ciou pravidla pre parser: COMPARISON (porovnanie dvoch hodn�t).
 */
public class Comparison extends And implements Condition, AssignmentValue, Command {
//    private boolean isNeg;
    private int isNeg;
    private AssignmentValue value1;
    private AssignmentValue value2;
    private List<AssignmentValue> values;
    private String symbol;
    private int status;

    /**
     * Kon�truktor, ktor� spracov�va vstupn� �daje pre pou�itie v �al��ch met�dach objektu.
     * @param isNeg predstavuje po�et zadan�ch neg�ci�.
     * @param value1 je prv� hodnota v pr�kaze porovnania.
     * @param value2 je druh� hodnota v pr�kaze porovnania.
     * @param symbol predstavuje symbol medzi hodnotami.
     */
    public Comparison(int isNeg, AssignmentValue value1, AssignmentValue value2, String symbol) {
        this.isNeg = isNeg;
        this.value1 = value1;
        this.value2 = value2;
        this.symbol = symbol;
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
        return status == 1 && value2.isDone() && value1.isDone();
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
                sb.append(value1).append(symbol).append(value2);
                for(int i=0; i<isNeg; i++){
                    sb.append(")");
                }
                sb.append("]");
                return sb.toString();
//                return "TB[" + value1 + symbol + value2 + "]" + (isNeg ? ":NEG" : "");
            case 1:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(value2.print()).append(":").append(value1.print()).append(":").append(getSymbol());
                for(int i=0; i<isNeg; i++){
                    sb2.append(":NEG");
                }
                return sb2.toString();
//            return value2.print()+":"+value1.print()+":"+getSymbol() + (isNeg ? ":NEG" : "");
        }
        return toString();
    }

    /**
     * @return spr�vnu in�trukciu na z�klade znaku porovn�vania.
     */
    private String getSymbol() {
        switch (symbol) {
            case "<":
                return "LT";
            case ">":
                return "GT";
            case "==":
                return "EQ";
            case "<=":
                return "LE";
            case ">=":
                return "GE";
        }
        return symbol;
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
        sb.append("(").append(value1).append(symbol).append(value2).append(")");
        return sb.toString();
//        return (isNeg ? "!" : "") + "(" + value1 + symbol + value2 + ")";
    }
}
