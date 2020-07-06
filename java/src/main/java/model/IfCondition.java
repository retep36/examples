package model;

import java.util.List;

/**
 * Trieda s implement�ciou pravidla pre parser: IF CONDITION (cyklus vetvenia).
 */
public class IfCondition implements Command {
    private Condition condition;
    private List<Command> thenCommands;
    private List<Command> elseCommands;
    private int status = 0;

    /**
     * Kon�truktor, ktor� spracov�va vstupn� �daje pre pou�itie v �al��ch met�dach objektu.
     * @param condition vklad� podmienku pr�kazu ako parameter kon�truktora.
     * @param thenCommands predstavuje zoznam pr�kazov za k���ov�m slovom then.
     * @param elseCommands predstavuje zoznam pr�kazov za k���ov�m slovom else.
     */
    public IfCondition(Condition condition, List<Command> thenCommands, List<Command> elseCommands) {
        this.condition = condition;
        this.thenCommands = thenCommands;
        this.elseCommands = elseCommands;
    }

    /**
     * @return true, ak uz su vyp�san� v�etky kroky rie�enia.
     */
    @Override
    public boolean isDone() {
        return status == 1 && areCommandsDone() && condition.isDone();
    }

    /**
     * @return true, ak s� vyp�san� in�trukcie z pr�kazov za k���ov�mi slovami then a else.
     */
    private boolean areCommandsDone() {
        boolean areDone = true;
        for (Command command : thenCommands) {
            areDone &= command.isDone();
        }
        for (Command command : elseCommands) {
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
                return condition.print()+":BRANCH("+printCommands(thenCommands)+","+printCommands(elseCommands)+")";
        }
        return toString();
    }

    /**
     * @param commands predstavuje zoznam pr�kazov za k���ov�mi slovami then a else.
     * @return v�pis in�trukci� za k���ov�mi slovami then a else, ak u� �al�ie nie je potrebn� vykona�.
     */
    private String printCommands(List<Command> commands) {
        StringBuilder sb = new StringBuilder();
        for (Command command : commands) {
            sb.append(command.print());
            sb.append(":");
        }
        return sb.toString();
    }

    /**
     * @return v�pis p�vodn�ho zadania vstupn�ho pr�kazu.
     * Vyu��va sa pri vyp�san� prv�ho kroku generovania in�trukci�.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("if ");
        sb.append(condition);
        System.out.println("cond " + condition);
        sb.append(" then ");
        for (Command command : thenCommands) {
            sb.append(command);
            sb.append(";");
        }
        if (thenCommands.isEmpty()) {
            sb.append("skip ");
        } else {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(" else ");
        for (Command command : elseCommands) {
            sb.append(command);
            sb.append(";");
        }
        if (elseCommands.isEmpty()) {
            sb.append("skip");
        } else {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
