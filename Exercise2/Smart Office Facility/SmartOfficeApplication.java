import java.time.LocalTime;
import java.util.Scanner;
import config.OfficeConfiguration;
import bookings.*;

public class SmartOfficeApplication {
    public static void main(String[] args) {
        OfficeConfiguration officeConfig = OfficeConfiguration.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Smart Office Facility Management System!");

        System.out.print("Enter the number of meeting rooms to configure: ");
        int roomCount = getValidatedIntegerInput(scanner);

        for (int i = 1; i <= roomCount; i++) {
            System.out.print("Enter capacity for Room " + i + ": ");
            int capacity = getValidatedIntegerInput(scanner);
            officeConfig.configureRoom(i, capacity);
        }

        boolean isRunning = true;

        while (isRunning) {
            isRunning = showMenu(scanner, officeConfig);
        }

        scanner.close();
    }

    private static boolean showMenu(Scanner scanner, OfficeConfiguration officeConfig) {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Book a room");
        System.out.println("2. Cancel a booking");
        System.out.println("3. Check room status");
        System.out.println("4. Exit");

        System.out.print("Enter your choice: ");
        int choice = getValidatedIntegerInput(scanner);

        switch (choice) {
            case 1:
                System.out.print("Enter room number: ");
                int roomNumber = getValidatedIntegerInput(scanner);
                System.out.print("Enter booking start time (e.g., 09:00): ");
                String timeInput = scanner.next();
                LocalTime startTime = LocalTime.parse(timeInput);
                System.out.print("Enter duration in minutes: ");
                int duration = getValidatedIntegerInput(scanner);
                RoomBooking roomBooking = new RoomBooking(roomNumber, startTime, duration);
                roomBooking.execute();
                break;
            case 2:
                System.out.print("Enter room number to cancel booking: ");
                roomNumber = getValidatedIntegerInput(scanner);
                CancelBookingCommand cancelCommand = new CancelBookingCommand(roomNumber);
                cancelCommand.execute();
                break;
            case 3:
                System.out.print("Enter room number to check status: ");
                roomNumber = getValidatedIntegerInput(scanner);
                checkRoomStatus(officeConfig, roomNumber);
                break;
            case 4:
                System.out.println("Exiting the system...");
                return false;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
        return true; 
    }

    private static void checkRoomStatus(OfficeConfiguration officeConfig, int roomId) {
        if (!officeConfig.roomExists(roomId)) {
            System.out.println("Room " + roomId + " does not exist.");
            return;
        }
        if (officeConfig.isRoomBooked(roomId)) {
            System.out.println("Room " + roomId + " is currently booked.");
        } else {
            System.out.println("Room " + roomId + " is available.");
        }
    }

    private static int getValidatedIntegerInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
