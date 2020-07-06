package model;

import java.util.List;

/**
 * Trieda s implement�ciou pravidla pre parser: WHILE LOOP (cyklus while).
 */
public class WhileLoop implements Command {
    private Condition condition;
    private List<Command> doCommands;
    private int status = 0;

    /**
     * Kon�truktor, ktor� spracov�va vstupn� �daje pre pou�itie v �al��ch met�dach objektu.
     * @param condition vklad� podmienku pr�kazu ako parameter kon�truktora.
     * @param doCommands predstavuje zoznam pr�kazov za k���ov�m slovom do.
     */
    public WhileLoop(Condition condition, List<Command> doCommands) {
        this.condition = condition;
        this.doCommands = doCommands;
    }

    /**
     * @return true, ak uz su vyp�san� v�etky kroky rie�enia.
     */
    @Override
    public boolean isDone() {
        return status == 1 && areCommandsDone() && condition.isDone();
    }

    /**
     * @return true, ak s� vyp�san� in�trukcie z pr�kazov za k���ov�m slovom do.
     */
    private boolean areCommandsDone() {
        boolean areDone = true;
        for (Command command : doCommands) {
            areDone &= command.isDone();
        }
        return areDone;
    }

    /**
     * @return v�pis jednotliv�ch krokov.
     */
    @Override
    public String print() {
        switch (status) {
            case 0:
                status++;
                return "TS[" + toString() + "]";
            case 1:
                return "LOOP("+condition.print()+","+printCommands(doCommands)+")";
        }
        return toString();
    }

    /**
     * @param commands predstavuje zoznam pr�kazov za k���ov�m slovom do.
     * @return v�pis in�trukci� za k���ov�mi slovami then a else, ak u� �al�ie nie je potrebn� vykona�.
     */
    private String printCommands(List<Command> commands) {
        StringBuilder sb = new StringBuilder();
        for (Command command : commands) {
            sb.append(command.print());
            sb.append(":");

        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * @return v�pis p�vodn�ho zadania vstupn�ho pr�kazu.
     * Vyu��va sa pri vyp�san� prv�ho kroku generovania in�trukci�.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("while ");
        sb.append(condition);
        sb.append(" do (");
        for (Command command : doCommands) {
            sb.append(command);
            sb.append(";");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }
}
