package app;

import engine.CalculatorEngine;
import operations.binaryOperations.*;
import operations.unaryOperations.SquareRoot;

import java.util.Scanner;

/**
 * @Author Omar Mahmoud
 */
public class Main {

    private static final CalculatorEngine calculatorEngine = new CalculatorEngine();
    private static final Addition addition = new Addition();
    private static final Subtraction subtraction = new Subtraction();
    private static final Multiplication multiplication = new Multiplication();
    private static final Division division = new Division();
    private static final Modulus modulus = new Modulus();
    private static final Power power = new Power();
    private static final SquareRoot squareRoot = new SquareRoot();

    public static void main(String[] args) {
        System.out.println("Welcome to the Calculator App!");
        System.out.println("This is a simple calculator app to perform basic mathematical operations.");
        System.out.println("This is my first project in Java, so I hope you like it!\n");

        Scanner scanner = new Scanner(System.in);

        boolean exit = true;

        while (exit) {

            System.out.println("Enter \"GO\" to start the app.");
            System.out.println("Enter \"EXIT\" to exit the app.\n");

            String input = scanner.nextLine();

            if (input.equals("EXIT")) {
                exit = false;
                continue;
            }

            if (!input.equals("GO")) {
                do {
                    System.err.println("Invalid Input!");
                    System.err.println("Enter \"GO\" to start the app. Or enter \"EXIT\" to exit the app.\n");
                    input = scanner.nextLine();
                    // Add exit option here
                } while (!input.equals("GO"));
            }

            System.out.println("Do you want to perform a single number or two number operation?");
            System.out.println("Enter \"SINGLE\" for a single number operation.");
            System.out.println("Enter \"DOUBLE\" for a two number operation.\n");

            input = scanner.nextLine();

            while (!input.equals("SINGLE") && !input.equals("DOUBLE")) {
                System.out.println("Invalid Input!");
                input = scanner.nextLine();
            }

            if (input.equals("SINGLE")) {
                System.out.println("Enter the number: ");
                double number = scanner.nextInt();
                System.out.println("Enter the operator: ");
                char operator = scanner.next().charAt(0);
                scanner.nextLine();

                if (operator == '<') {
                    System.out.println("The square root of " + number + " is " + calculatorEngine.calculate(squareRoot, number) + "\n");
                } else {
                    System.out.println("Invalid operator!");
                }
                continue;
            }

            System.out.println("Enter the first number: ");
            double number_1 = scanner.nextInt();
            System.out.println("Enter the second number: ");
            double number_2 = scanner.nextInt();
            System.out.println("Enter the operator: ");
            char double_operator = scanner.next().charAt(0);
            scanner.nextLine();

            switch (double_operator) {
                case '+':
                    System.out.println("The sum of " + number_1 + " and " + number_2 + " is " + calculatorEngine.calculate(addition, number_1, number_2) + "\n");
                    break;
                case '-':
                    System.out.println("The difference of " + number_1 + " and " + number_2 + " is " + calculatorEngine.calculate(subtraction, number_1, number_2) + "\n");
                    break;
                case '*':
                    System.out.println("The product of " + number_1 + " and " + number_2 + " is " + calculatorEngine.calculate(multiplication, number_1, number_2) + "\n");
                    break;
                case '/':
                    System.out.println("The quotient of " + number_1 + " and " + number_2 + " is " + calculatorEngine.calculate(division, number_1, number_2) + "\n");
                    break;
                case '%':
                    System.out.println("The remainder of " + number_1 + " and " + number_2 + " is " + calculatorEngine.calculate(modulus, number_1, number_2) + "\n");
                    break;
                case '^':
                    System.out.println("The power of " + number_1 + " and " + number_2 + " is " + calculatorEngine.calculate(power, number_1, number_2) + "\n");
                    break;
                default:
                    System.out.println("Invalid operator!");
            }
        }
        scanner.close();
        System.out.println("Thank you for using the Calculator App!");
        System.out.println("Goodbye!");
        System.exit(0);
    }
}