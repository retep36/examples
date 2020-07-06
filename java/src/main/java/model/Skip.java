package model;

/**
 * Trieda s implement�ciou pravidla pre parser: SKIP.
 */
public class Skip implements Command {
    private int status = 0;

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
        if (status == 0) {
            status++;
            return "TS[skip]";
        } else {
            return "EMPTYOP";
        }
    }

    /**
     * @return v�pis p�vodn�ho zadania vstupn�ho pr�kazu.
     * Vyu��va sa pri vyp�san� prv�ho kroku generovania in�trukci�.
     */
    @Override
    public String toString() {
        return "skip";
    }
}
