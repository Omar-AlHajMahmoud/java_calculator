package gui;

import engine.CalculatorEngine;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import operations.binaryOperations.Addition;
import operations.binaryOperations.Division;
import operations.binaryOperations.Multiplication;
import operations.binaryOperations.Subtraction;

import javafx.event.ActionEvent;

/**
 * @Author Omar Mahmoud
 */
public class CalculatorManager {

    private static final CalculatorEngine calculatorEngine = new CalculatorEngine();
    private static final Addition addition = new Addition();
    private static final Subtraction subtraction = new Subtraction();
    private static final Multiplication multiplication = new Multiplication();
    private static final Division division = new Division();

    private double currentNumber = 0;
    private String currentOperator = "";
    private boolean waitingForOperand = false;

    public void handleNumberClick (Button button, TextArea textArea) {
        String number = button.getText();
        appendToDisplay(number, textArea);
    }

    private void appendToDisplay (String number, TextArea textArea) {
        if (waitingForOperand) {
            textArea.setText(number);
            waitingForOperand = false;
        } else {
            String current = textArea.getText();
            if (current.equals("0")) {
                textArea.setText(number);
            } else {
                textArea.setText(current + number);
            }
        }
    }

    public void handleOperatorClick (Button button, TextArea textArea) {
        String operator = button.getText();
        processOperator(operator, textArea);
    }

    private void processOperator (String operator, TextArea textArea) {
        double number = Double.parseDouble(textArea.getText());

        if (!currentOperator.isEmpty() && !waitingForOperand) {
            double result = performCalculation(currentNumber, number, operator);
            textArea.setText(Double.toString(result));
            currentNumber = result;
        } else {
            currentNumber = number;
        }

        currentOperator = operator;
        waitingForOperand = true;
    }

    private double performCalculation (double currentNumber, double number, String operator) {
        return switch (operator) {
            case "+" -> calculatorEngine.calculate(addition, currentNumber, number);
            case "-" -> calculatorEngine.calculate(subtraction, currentNumber, number);
            case "X" -> calculatorEngine.calculate(multiplication, currentNumber, number);
            case "/" -> calculatorEngine.calculate(division, currentNumber, number);
            default -> number;
        };
    }

    public void handleEqualsClick (TextArea textArea) {
        if (!currentOperator.isEmpty() && !waitingForOperand) {
            double secondNumber = Double.parseDouble(textArea.getText());
            double result = performCalculation(currentNumber, secondNumber, currentOperator);
            textArea.setText(Double.toString(result));
            currentOperator = "";
            waitingForOperand = true;
        }
    }

    public void handleClearClick (TextArea textArea) {
        textArea.setText("0");
        currentNumber = 0;
        currentOperator = "";
        waitingForOperand = false;
    }
}
