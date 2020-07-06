package model;

import java.util.List;

/**
 * Trieda s implementáciou pravidla pre parser: OPERATION (matematická operácia).
 */
public class Operation implements AssignmentValue, Command {
    private Operation value1;
    private Operation value2;
    private String symbol;
    private boolean hasParenthesis;
    private int status = 0;
    private List<AssignmentValue> values;


    /**
     * Prázdny konštruktor na vytvorenie inštancie objektu.
     */
    public Operation() {

    }

    /**
     * Konštruktor, ktorý spracováva vstupné údaje pre použitie v ïalších metódach objektu.
     * @param value1 predstavuje hodnotu v príkaze operácie.
     * @param value2 predstavuje hodnotu v príkaze operácie.
     * @param symbol predstavuje symbol medzi dvomi hodnotami.
     * @param hasParenthesis je boolean hodnota, true ak sú zadané v príkaze zátvorky, inak false.
     */
    public Operation(Operation value1, Operation value2, String symbol, boolean hasParenthesis) {
        this.value1 = value1;
        this.value2 = value2;
        this.symbol = symbol;
        this.hasParenthesis = hasParenthesis;
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
                return "TE[" + value1 + symbol + value2 + "]";
            case 1:
                return value2.print() + ":" + value1.print() + ":"
                        + (symbol.equals("+") ? "ADD" : symbol.equals("-") ? "SUB" : "MULT");
        }
        return value1 + symbol + value2;
    }

    /**
     * @return výpis pôvodného zadania vstupného príkazu.
     * Využíva sa pri vypísaní prvého kroku generovania inštrukcií.
     */
    @Override
    public String toString() {
        return value1 + symbol + value2;
    }

//    public Operation getValue1() {
//        return value1;
//    }

    /**
     * Set metóda nastavujúca prvú hodnotu operácie.
     * @param value1 je hodnota.
     */
    public void setValue1(Operation value1) {
        this.value1 = value1;
    }

//    public Operation getValue2() {
//        return value2;
//    }

    /**
     * Set metóda nastavujúca druhú hodnotu operácie.
     * @param value2 je hodnota.
     */
    public void setValue2(Operation value2) {
        this.value2 = value2;
    }

    /**
     * @return symbol nachadzajúci sa v príkaze typu operácia.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Set metóda nastavujúca symbol znamienka v operácií.
     * @param symbol predstavuje znamienko.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
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
}
