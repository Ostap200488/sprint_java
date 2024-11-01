package utils;

public class Formatter {
    public static void displayLine() {
        System.out.println("----------------------------------------");
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayError(String error) {
        System.err.println(error);
    }
}
