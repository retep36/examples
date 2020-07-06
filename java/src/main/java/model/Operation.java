package model;

import java.util.List;

/**
 * Trieda s implement�ciou pravidla pre parser: OPERATION (matematick� oper�cia).
 */
public class Operation implements AssignmentValue, Command {
    private Operation value1;
    private Operation value2;
    private String symbol;
    private boolean hasParenthesis;
    private int status = 0;
    private List<AssignmentValue> values;


    /**
     * Pr�zdny kon�truktor na vytvorenie in�tancie objektu.
     */
    public Operation() {

    }

    /**
     * Kon�truktor, ktor� spracov�va vstupn� �daje pre pou�itie v �al��ch met�dach objektu.
     * @param value1 predstavuje hodnotu v pr�kaze oper�cie.
     * @param value2 predstavuje hodnotu v pr�kaze oper�cie.
     * @param symbol predstavuje symbol medzi dvomi hodnotami.
     * @param hasParenthesis je boolean hodnota, true ak s� zadan� v pr�kaze z�tvorky, inak false.
     */
    public Operation(Operation value1, Operation value2, String symbol, boolean hasParenthesis) {
        this.value1 = value1;
        this.value2 = value2;
        this.symbol = symbol;
        this.hasParenthesis = hasParenthesis;
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
                return "TE[" + value1 + symbol + value2 + "]";
            case 1:
                return value2.print() + ":" + value1.print() + ":"
                        + (symbol.equals("+") ? "ADD" : symbol.equals("-") ? "SUB" : "MULT");
        }
        return value1 + symbol + value2;
    }

    /**
     * @return v�pis p�vodn�ho zadania vstupn�ho pr�kazu.
     * Vyu��va sa pri vyp�san� prv�ho kroku generovania in�trukci�.
     */
    @Override
    public String toString() {
        return value1 + symbol + value2;
    }

//    public Operation getValue1() {
//        return value1;
//    }

    /**
     * Set met�da nastavuj�ca prv� hodnotu oper�cie.
     * @param value1 je hodnota.
     */
    public void setValue1(Operation value1) {
        this.value1 = value1;
    }

//    public Operation getValue2() {
//        return value2;
//    }

    /**
     * Set met�da nastavuj�ca druh� hodnotu oper�cie.
     * @param value2 je hodnota.
     */
    public void setValue2(Operation value2) {
        this.value2 = value2;
    }

    /**
     * @return symbol nachadzaj�ci sa v pr�kaze typu oper�cia.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Set met�da nastavuj�ca symbol znamienka v oper�ci�.
     * @param symbol predstavuje znamienko.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
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
}
