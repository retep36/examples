package model;

import java.util.List;

/**
 * Trieda s implementáciou pravidla pre parser: WHILE LOOP (cyklus while).
 */
public class WhileLoop implements Command {
    private Condition condition;
    private List<Command> doCommands;
    private int status = 0;

    /**
     * Konštruktor, ktorı spracováva vstupné údaje pre pouitie v ïalších metódach objektu.
     * @param condition vkladá podmienku príkazu ako parameter konštruktora.
     * @param doCommands predstavuje zoznam príkazov za k¾úèovım slovom do.
     */
    public WhileLoop(Condition condition, List<Command> doCommands) {
        this.condition = condition;
        this.doCommands = doCommands;
    }

    /**
     * @return true, ak uz su vypísané všetky kroky riešenia.
     */
    @Override
    public boolean isDone() {
        return status == 1 && areCommandsDone() && condition.isDone();
    }

    /**
     * @return true, ak sú vypísané inštrukcie z príkazov za k¾úèovım slovom do.
     */
    private boolean areCommandsDone() {
        boolean areDone = true;
        for (Command command : doCommands) {
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
                return "LOOP("+condition.print()+","+printCommands(doCommands)+")";
        }
        return toString();
    }

    /**
     * @param commands predstavuje zoznam príkazov za k¾úèovım slovom do.
     * @return vıpis inštrukcií za k¾úèovımi slovami then a else, ak u ïalšie nie je potrebné vykona.
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
     * @return vıpis pôvodného zadania vstupného príkazu.
     * Vyuíva sa pri vypísaní prvého kroku generovania inštrukcií.
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
