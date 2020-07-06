package model;

import java.util.List;

/**
 * Trieda s implement�ciou pravidla pre parser: SEQUENCE (sekvenciu pr�kazov na vstupe).
 */
public class Sequence {
    private List<Command> commands;

    /**
     * @param commands vklad� do kon�truktora zoznam pr�kazov zadan�ch vo vstupnom programe.
     */
    public Sequence(List<Command> commands) {
        this.commands = commands;
    }

    private StringBuilder sb = new StringBuilder();

    /**
     * Pomocn� met�da na zlo�enie v�sledn�ho v�pisu.
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
     * @return vracia celkov� v�pis.
     */
    public String getCommands() {
        return sb.toString();
    }

    /**
     * Met�da, ktor� zlo�� jednotliv� v�pisy z ostatn�ch objektov.
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
     * @return v�pis p�vodn�ho zadania vstupn�ho pr�kazu.
     * Vyu��va sa pri vyp�san� prv�ho kroku generovania in�trukci�.
     */
    private boolean allCommandsAreDone() {
        boolean areDone = true;
        for (Command command : commands) {
            areDone &= command.isDone();
        }
        return areDone;
    }
}
