package view;

import java.util.Scanner;

/**
 * I/O Class
 * @author Mathoas
 */
public class InputOutputHandler {

    /**
     * Method to print error messages caused by the user
     * @param message Error message
     */
    public static void printError(String message) {
        System.out.println("> Error: " + message);
    }

    /**
     * Method to print error messages caused by internal processes
     * @param message Error/Debug message
     */
    public static void printDebugMessage(String message) {
        System.err.println("> Debug error: " + message);
    }

    /**
     * Method to print a message to the user
     * @param message Message for the user
     */
    public static void printMessage(String message) {
        System.out.println("> " + message);
    }

    /**
     * Method to collect user input. If the input is empty or black the user will be
     * prompted to reenter. This insures a non empty/black return string
     * @return Returns the user input
     */
    public static String collectInput() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String input = scanner.nextLine();

            if (input.isEmpty() || input.isBlank()) {
                printError("Invalid input!");
                continue;
            }

            scanner.close();
            return input;
        }
    }

}
