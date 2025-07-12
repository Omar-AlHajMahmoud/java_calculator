package cli;

import engine.CalculatorEngine;

import java.util.Scanner;

/**
 * Command Line Interface for a basic calculator application.
 * This class provides an interactive CLI that allows the user to run basic mathematical operations, including:
 * addition, subtraction, multiplication, and division.
 *
 * <p>The calculator maintains a running total and allows users to perform sequential operations on the current result.
 * Users can clear the calculator or exit at any time.</p>
 *
 * @Author Omar Mahmoud
 */
public class CLIHome {

    /**
     * The calculator engine instance that is used to run the mathematical operations.
     * The engine handles the actual calculation logic.
     */
    private static final CalculatorEngine calculatorEngine = new CalculatorEngine();

    /**
     * The main entry point to the CLI application.
     * Initializes the interface and handles the main program loop.
     *
     * @param args command line arguments are not used in this application
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Calculator App!");
        System.out.println("This is a simple calculator app to perform basic mathematical operations.");
        System.out.println("This is my first project in Java, so I hope you like it!\n");

        Scanner scanner = new Scanner(System.in);
        double currentNumber = 0;
        boolean isFirstCalculation = true;

        displayCurrentNumber(currentNumber);

        while (true) {

            if (isFirstCalculation) {
                System.out.println("Please enter the first number or \"EXIT\" to quit: ");

                String input = scanner.nextLine();

                if (input.equals("EXIT")) {
                    break;
                } else {
                    currentNumber = Double.parseDouble(input);
                }

                displayCurrentNumber(currentNumber);
                isFirstCalculation = false;
                continue;
            }

            System.out.println("Enter an operator (+, -, *, /) or \"EXIT\" to quit: ");
            String input = scanner.nextLine().trim();

            if (input.equals("EXIT")) {
                break;
            }

            if (input.length() != 1 || !isValidOperator(input.charAt(0))) {
                System.out.println("Invalid operator, please enter a valid operator (+, -, *, /).");
                continue;
            }

            String operator = String.valueOf(input.charAt(0));

            System.out.println("Please enter the second number or \"EXIT\" to quit: ");

            String secondNumberInput = scanner.nextLine();
            double secondNumber;

            if (secondNumberInput.equals("EXIT")) {
                break;
            } else {
                secondNumber = Double.parseDouble(secondNumberInput);
            }

            currentNumber = performCalculation(operator, currentNumber, secondNumber);

            displayCurrentNumber(currentNumber);

            System.out.println("Press ENTER to continue, type \"CLEAR\" to start over, type \"EXIT\" to quit: ");

            String decision = scanner.nextLine().trim();
            if (decision.equals("CLEAR")) {
                currentNumber = 0;
                isFirstCalculation = true;
                System.out.println("Calculator Cleared!");
                displayCurrentNumber(currentNumber);
            } else if (decision.equals("EXIT")) {
                break;
            }
        }
        scanner.close();
        System.out.println("Thank you for using the Calculator App!");
        System.out.println("Goodbye!");
    }

    /**
     * Displays the current number of the calculator in the console.
     *
     * @param currentNumber the current number to display.
     */
    private static void displayCurrentNumber(double currentNumber) {
        System.out.println("========================");
        System.out.println("Current number: " + currentNumber);
        System.out.println("========================");
    }

    /**
     * Validates whether the provided character is a supported mathematical operation.
     *
     * <p>Supported operations:</p>
     * <ul>
     *     <li>'+' for addition</li>
     *     <li>'-' for subtraction</li>
     *     <li>'*' for multiplication</li>
     *     <li>'/' for division</li>
     * </ul>
     *
     * @param operator the character to validate as an operator.
     * @return {@code true} if the operator is valid, {@code false} otherwise
     */
    public static boolean isValidOperator(char operator) {
        return operator == '+' || operator == '-' || operator == '*' || operator == '/';
    }

    /**
     * Performs the mathematical operation using the calculator engine.
     *
     * <p>If an error happens during calculation, the message is printed in the console and {@code Double.MIN_VALUE}
     * is returned as an error indicator.</p>
     *
     * @param operator the mathematical operator as a string ("+", "-", "*", "/")
     * @param currentNumber the first operand (current calculator value)
     * @param secondNumber the second operand (user input)
     * @return the result of the calculation, or {@code Double.MIN_VALUE} if an error occurs
     */
    public static double performCalculation(String operator, double currentNumber, double secondNumber) {
        try {
            return calculatorEngine.calculate(operator, currentNumber, secondNumber);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return Double.MIN_VALUE;
        }
    }
}