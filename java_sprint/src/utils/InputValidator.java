package utils;

import java.util.Scanner;

public class InputValidator {
    private static Scanner scanner = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    public static boolean getYesNo(String prompt) {
        System.out.print(prompt + " (y/n): ");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("y");
    }
}
