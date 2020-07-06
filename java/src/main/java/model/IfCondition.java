package model;

import java.util.List;

/**
 * Trieda s implementáciou pravidla pre parser: IF CONDITION (cyklus vetvenia).
 */
public class IfCondition implements Command {
    private Condition condition;
    private List<Command> thenCommands;
    private List<Command> elseCommands;
    private int status = 0;

    /**
     * Konštruktor, ktorı spracováva vstupné údaje pre pouitie v ïalších metódach objektu.
     * @param condition vkladá podmienku príkazu ako parameter konštruktora.
     * @param thenCommands predstavuje zoznam príkazov za k¾úèovım slovom then.
     * @param elseCommands predstavuje zoznam príkazov za k¾úèovım slovom else.
     */
    public IfCondition(Condition condition, List<Command> thenCommands, List<Command> elseCommands) {
        this.condition = condition;
        this.thenCommands = thenCommands;
        this.elseCommands = elseCommands;
    }

    /**
     * @return true, ak uz su vypísané všetky kroky riešenia.
     */
    @Override
    public boolean isDone() {
        return status == 1 && areCommandsDone() && condition.isDone();
    }

    /**
     * @return true, ak sú vypísané inštrukcie z príkazov za k¾úèovımi slovami then a else.
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
     * @return vıpis jednotlivıch krokov.
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
     * @param commands predstavuje zoznam príkazov za k¾úèovımi slovami then a else.
     * @return vıpis inštrukcií za k¾úèovımi slovami then a else, ak u ïalšie nie je potrebné vykona.
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
     * @return vıpis pôvodného zadania vstupného príkazu.
     * Vyuíva sa pri vypísaní prvého kroku generovania inštrukcií.
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
