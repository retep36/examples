package model;

import java.util.List;

/**
 * Trieda s implementáciou pravidla pre parser: SEQUENCE (sekvenciu príkazov na vstupe).
 */
public class Sequence {
    private List<Command> commands;

    /**
     * @param commands vkladá do konštruktora zoznam príkazov zadaných vo vstupnom programe.
     */
    public Sequence(List<Command> commands) {
        this.commands = commands;
    }

    private StringBuilder sb = new StringBuilder();

    /**
     * Pomocná metóda na zloženie výsledného výpisu.
     */
    private void printCommands() {
        sb.append(System.getProperty("line.separator"));
        sb.append("= ");
        for (Command command : commands) {
//            System.out.print(command.print());
            sb.append(command.print());
            if (!command.equals(commands.get(commands.size()-1))) {
//                System.out.print(":");
                sb.append(":");
            }
        }
//        System.out.println();
        System.out.println(sb.toString());
    }

    /**
     * @return vracia celkový výpis.
     */
    public String getCommands() {
        return sb.toString();
    }

    /**
     * Metóda, ktorá zloží jednotlivé výpisy z ostatných objektov.
     */
    public void print() {
        StringBuilder sb = new StringBuilder();
        for (Command command : commands) {
            sb.append(command);
//            System.out.print(command);
            if (!command.equals(commands.get(commands.size()-1))) {
                sb.append(":");
//                System.out.print(":");
            }
        }
        while (!allCommandsAreDone()) {
            printCommands();
        }
        printCommands();
//        System.out.println("my " + sb.toString());
    }

    /**
     * @return výpis pôvodného zadania vstupného príkazu.
     * Využíva sa pri vypísaní prvého kroku generovania inštrukcií.
     */
    private boolean allCommandsAreDone() {
        boolean areDone = true;
        for (Command command : commands) {
            areDone &= command.isDone();
        }
        return areDone;
    }
}
