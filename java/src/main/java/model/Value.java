package model;

/**
 * Trieda s implementáciou pravidla pre parser: VALUE (hodnota).
 */
public class Value extends Operation {
    private String varName;
    private int value;
    private int status = 0;

    /**
     * Konštruktor, ktorı spracováva vstupné údaje pre pouitie v ïalších metódach objektu.
     * @param varName predstavuje názov, ktorı môe hodnota nadobudnú.
     * @param value predstavuje èíselnú hodnotu.
     */
    public Value(String varName, int value) {
        this.varName = varName;
        this.value = value;
    }

    /**
     * @return true, ak uz su vypísané všetky kroky riešenia.
     */
    @Override
    public boolean isDone() {
        return status == 1;
    }

    /**
     * @return vıpis jednotlivıch krokov.
     */
    @Override
    public String print() {
        switch (status) {
            case 0:
                status++;
                return "TE[" + toString() + "]";
            case 1:
                return varName != null ? "FETCH-"+varName : "PUSH-"+value;
        }
        return toString();
    }

    /**
     * @return vıpis pôvodného zadania vstupného príkazu.
     * Vyuíva sa pri vypísaní prvého kroku generovania inštrukcií.
     */
    @Override
    public String toString() {
        return varName != null ? varName : Integer.toString(value);
    }
}
