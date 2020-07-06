package model;

/**
 * Trieda s implementáciou pravidla pre parser: ASSIGNMENT (priraïovací príkaz).
 */
public class Assignment implements Command {
    private String varName;
    private AssignmentValue value;
    private int status = 0;

    /**
     * Konštruktor, ktorý spracováva vstupné údaje pre použitie v ïalších metódach objektu.
     * @param varName predstavuje názov premennej.
     * @param value predstavuje hodnotu, ktorá je priradená názvu premennej.
     */
    public Assignment(String varName, AssignmentValue value) {
        this.varName = varName;
        this.value = value;
    }


    /**
     * @return výpis jednotlivých krokov.
     */
    @Override
    public String print() {
        switch (status) {
            case 0:
                status++;
                return "TS[" + varName + ":=" + value + "]";
            case 1:
                return value.print()+":STORE-"+varName;
        }
        return varName+":="+value;
    }

    /**
     * @return true, ak uz su vypísané všetky kroky riešenia.
     */
    @Override
    public boolean isDone() {
        return status == 1 && value.isDone();
    }

    /**
     * @return výpis pôvodného zadania vstupného príkazu.
     * Využíva sa pri vypísaní prvého kroku generovania inštrukcií.
     */
    @Override
    public String toString() {
        return varName+":="+value;
    }
}
