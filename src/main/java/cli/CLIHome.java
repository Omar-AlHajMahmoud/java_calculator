package cli;

import engine.CalculatorEngine;
import operations.Addition;
import operations.Division;
import operations.Multiplication;
import operations.Subtraction;

import java.util.Scanner;

/**
 * @Author Omar Mahmoud
 */
public class CLIHome {

    private static final CalculatorEngine calculatorEngine = new CalculatorEngine();
    private static final Addition addition = new Addition();
    private static final Subtraction subtraction = new Subtraction();
    private static final Multiplication multiplication = new Multiplication();
    private static final Division division = new Division();

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

            char operator = input.charAt(0);

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

    private static void displayCurrentNumber(double currentNumber) {
        System.out.println("========================");
        System.out.println("Current number: " + currentNumber);
        System.out.println("========================");
    }

    private static boolean isValidOperator(char operator) {
        return operator == '+' || operator == '-' || operator == '*' || operator == '/';
    }

    private static double performCalculation(char operator, double currentNumber, double secondNumber) {
        try {
            return switch (operator) {
                case '+' -> calculatorEngine.calculate(addition, currentNumber, secondNumber);
                case '-' -> calculatorEngine.calculate(subtraction, currentNumber, secondNumber);
                case '*' -> calculatorEngine.calculate(multiplication, currentNumber, secondNumber);
                case '/' -> calculatorEngine.calculate(division, currentNumber, secondNumber);
                default -> {
                    System.out.println("Invalid operator!");
                    yield Double.MIN_VALUE;
                }
            };
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return Double.MIN_VALUE;
        }
    }
}