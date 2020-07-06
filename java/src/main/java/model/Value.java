package model;

/**
 * Trieda s implement�ciou pravidla pre parser: VALUE (hodnota).
 */
public class Value extends Operation {
    private String varName;
    private int value;
    private int status = 0;

    /**
     * Kon�truktor, ktor� spracov�va vstupn� �daje pre pou�itie v �al��ch met�dach objektu.
     * @param varName predstavuje n�zov, ktor� m��e hodnota nadobudn��.
     * @param value predstavuje ��seln� hodnotu.
     */
    public Value(String varName, int value) {
        this.varName = varName;
        this.value = value;
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
                return "TE[" + toString() + "]";
            case 1:
                return varName != null ? "FETCH-"+varName : "PUSH-"+value;
        }
        return toString();
    }

    /**
     * @return v�pis p�vodn�ho zadania vstupn�ho pr�kazu.
     * Vyu��va sa pri vyp�san� prv�ho kroku generovania in�trukci�.
     */
    @Override
    public String toString() {
        return varName != null ? varName : Integer.toString(value);
    }
}
