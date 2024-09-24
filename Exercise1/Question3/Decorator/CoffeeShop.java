package Question3.Decorator;

import Question3.Decorator.Logs.Logger;

import java.util.Scanner;

public class CoffeeShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger.log("Coffee Shop App started.");
        
        String continueOrder;

        do {
            try {
                System.out.println("Welcome to the Coffee Shop!");
                Coffee coffee = new SimpleCoffee();

                System.out.print("Would you like to add milk? (yes/no): ");
                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                    coffee = new MilkDecorator(coffee);
                }

                System.out.print("Would you like to add sugar? (yes/no): ");
                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                    coffee = new SugarDecorator(coffee);
                }

                System.out.println("Your order: " + coffee.getDescription());
                System.out.printf("Total cost: $%.2f\n", coffee.cost());
                
                System.out.print("Would you like to make another order? (yes/no): ");
                continueOrder = scanner.nextLine().trim().toLowerCase();

            } catch (Exception e) {
                Logger.log("An error occurred: " + e.getMessage());
                System.err.println("An error occurred: " + e.getMessage());
                continueOrder = "no";
            }
        } while (continueOrder.equals("yes"));

        scanner.close();
        Logger.log("Coffee Shop App ended.");
        System.out.println("Thank you for visiting the Coffee Shop!");
    }
}
