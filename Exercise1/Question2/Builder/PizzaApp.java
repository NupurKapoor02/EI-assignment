import Logs.Logger;
import java.util.Scanner;

public class PizzaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger.log("Pizza Order Application started.");

        try {
            System.out.print("Enter pizza size (Small/Medium/Large): ");
            String size = scanner.nextLine().trim();

            boolean cheese = getYesNoInput(scanner, "Add cheese? (yes/no): ");
            boolean pepperoni = getYesNoInput(scanner, "Add pepperoni? (yes/no): ");
            boolean mushrooms = getYesNoInput(scanner, "Add mushrooms? (yes/no): ");
            boolean onions = getYesNoInput(scanner, "Add onions? (yes/no): ");

            Pizza pizza = new PizzaBuilder(size)
                    .addCheese(cheese)
                    .addPepperoni(pepperoni)
                    .addMushrooms(mushrooms)
                    .addOnions(onions)
                    .build();

            System.out.println("Your pizza is ready: " + pizza);
            Logger.log("Pizza ordered: " + pizza.toString());

        } catch (IllegalArgumentException e) {
            Logger.log("Error: " + e.getMessage());
        } catch (Exception e) {
            Logger.log("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
            Logger.log("Pizza Order Application has exited.");
        }
    }

    private static boolean getYesNoInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                Logger.log("Invalid input received. Please enter 'yes' or 'no'.");
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }
}
