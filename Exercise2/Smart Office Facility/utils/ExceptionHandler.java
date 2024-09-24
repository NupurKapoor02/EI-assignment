package utils;

public class ExceptionHandler {
    public static void handle(Exception e) {
        Logger.log("Error: " + e.getMessage());
    }
}
