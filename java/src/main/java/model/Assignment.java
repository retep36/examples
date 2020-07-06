package model;

/**
 * Trieda s implement�ciou pravidla pre parser: ASSIGNMENT (prira�ovac� pr�kaz).
 */
public class Assignment implements Command {
    private String varName;
    private AssignmentValue value;
    private int status = 0;

    /**
     * Kon�truktor, ktor� spracov�va vstupn� �daje pre pou�itie v �al��ch met�dach objektu.
     * @param varName predstavuje n�zov premennej.
     * @param value predstavuje hodnotu, ktor� je priraden� n�zvu premennej.
     */
    public Assignment(String varName, AssignmentValue value) {
        this.varName = varName;
        this.value = value;
    }


    /**
     * @return v�pis jednotliv�ch krokov.
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
     * @return true, ak uz su vyp�san� v�etky kroky rie�enia.
     */
    @Override
    public boolean isDone() {
        return status == 1 && value.isDone();
    }

    /**
     * @return v�pis p�vodn�ho zadania vstupn�ho pr�kazu.
     * Vyu��va sa pri vyp�san� prv�ho kroku generovania in�trukci�.
     */
    @Override
    public String toString() {
        return varName+":="+value;
    }
}
