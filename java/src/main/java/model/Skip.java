package model;

/**
 * Trieda s implementáciou pravidla pre parser: SKIP.
 */
public class Skip implements Command {
    private int status = 0;

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
        if (status == 0) {
            status++;
            return "TS[skip]";
        } else {
            return "EMPTYOP";
        }
    }

    /**
     * @return výpis pôvodného zadania vstupného príkazu.
     * Využíva sa pri vypísaní prvého kroku generovania inštrukcií.
     */
    @Override
    public String toString() {
        return "skip";
    }
}
