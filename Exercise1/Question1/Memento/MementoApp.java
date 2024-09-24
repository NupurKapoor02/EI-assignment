package Question1.Memento;
import Question1.Memento.Logs.Logger;
import java.util.Scanner;
public class MementoApp {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("\nEnter a new state (or type 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                running = false;
                continue;
            }

            try {
                originator.setState(input);
                caretaker.addMemento(originator.saveStateToMemento());
                Logger.log("Current state saved. Total saved states: " + caretaker.getMementoCount());

                System.out.print("Do you want to restore a state? (yes/no): ");
                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                    System.out.print("Enter the index of the memento to restore: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    Memento memento = caretaker.getMemento(index);
                    if (memento != null) {
                        originator.getStateFromMemento(memento);
                        System.out.println("Restored State: " + originator.getState());
                    } else {
                        Logger.log("No memento found at index: " + index);
                    }
                }
            } catch (IllegalArgumentException e) {
                Logger.log("Error: " + e.getMessage());
            }
        }
        scanner.close();
        Logger.log("Memento App has exited.");
    }
}

