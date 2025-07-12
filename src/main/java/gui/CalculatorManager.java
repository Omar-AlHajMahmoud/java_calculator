package gui;

import engine.CalculatorEngine;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Objects;

/**
 * Manager class to handle the calculator operations and user interactions in the GUI.
 *
 * <p>This calculator includes the current calculator's state, including:
 * <ul>
 *     <li>Current number</li>
 *     <li>Current operator selected</li>
 *     <li>Whether the calculator is waiting for a new operand</li>
 * </ul>
 *
 *
 * @Author Omar Mahmoud
 * @see CalculatorEngine
 */
public class CalculatorManager {

    /**
     * The calculator engine instance that is used to run the mathematical operations.
     * The engine handles the actual calculation logic.
     */
    private static final CalculatorEngine calculatorEngine = new CalculatorEngine();

    /**
     * The current number stored in the calculator's memory.
     * This value is either the first operand in the first calculation or the running value of previous calculations.
     */
    private double currentNumber = 0;

    /**
     * The currently selected mathematical operator.
     */
    private String currentOperator = "";

    /**
     * Flag indication whether the calculator is waiting for a new operand input.
     */
    private boolean waitingForOperand = false;

    /**
     * Handles number button clicks in the calculator GUI.
     *
     * @param button the number button that was clicked
     * @param calculatorDisplay the label displaying the current calculator value
     *
     * @see #appendToDisplay(String, Label)
     */
    public void handleNumberClick (Button button, Label calculatorDisplay) {
        String number = button.getText();
        appendToDisplay(number, calculatorDisplay);
    }

    /**
     * Updates the calculator display based on the current state.
     *
     * @param number the number string to append or display
     * @param calculatorDisplay the label displaying the current calculator value
     */
    private void appendToDisplay (String number, Label calculatorDisplay) {
        if (waitingForOperand) {
            calculatorDisplay.setText(number);
            waitingForOperand = false;
        } else {
            String current = calculatorDisplay.getText();
            if (current.equals("0")) {
                calculatorDisplay.setText(number);
            } else {
                calculatorDisplay.setText(current + number);
            }
        }
    }

    /**
     * Handles operator button clicks in the calculator GUI.
     *
     * @param button the operator button that was clicked
     * @param calculatorDisplay the label displaying the current calculator value
     *
     * @see #processOperator(String, Label)
     */
    public void handleOperatorClick (Button button, Label calculatorDisplay) {
        String operator = button.getText();
        processOperator(operator, calculatorDisplay);
    }

    /**
     * Processes a mathematical operator and updates the calculator state.
     *
     * @param operator the mathematical operator symbol as a string
     * @param calculatorDisplay the label displaying the current calculator value
     *
     * @see #performCalculation(double, double, String)
     */
    private void processOperator (String operator, Label calculatorDisplay) {
        double number = Double.parseDouble(calculatorDisplay.getText());

        if (!currentOperator.isEmpty() && !waitingForOperand) {
            try {
                double result = performCalculation(currentNumber, number, operator);
                calculatorDisplay.setText(Double.toString(result));
                currentNumber = result;
            } catch (RuntimeException e) {
                calculatorDisplay.setText("Error");
                currentNumber = 0;
            }
        } else {
            currentNumber = number;
        }

        currentOperator = operator;
        waitingForOperand = true;
    }

    /**
     * Performs a mathematical operation using the calculator engine.
     *
     * @param currentNumber the first operand in the calculation
     * @param number the second operand in the calculation
     * @param operator the mathematical operator to apply
     * @return the result of the mathematical operator
     */
    private double performCalculation (double currentNumber, double number, String operator) {
        try {
            return calculatorEngine.calculate(operator, currentNumber, number);
        } catch (ArithmeticException e) {
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
    }

    /**
     * Handles equals button clicks to execute the calculations.
     *
     * @param calculatorDisplay the label displaying the current calculator value
     *
     * @see #performCalculation(double, double, String)
     */
    public void handleEqualsClick (Label calculatorDisplay) {
        if (!currentOperator.isEmpty() && !waitingForOperand) {
            try {
                double secondNumber = Double.parseDouble(calculatorDisplay.getText());
                double result = performCalculation(currentNumber, secondNumber, currentOperator);
                calculatorDisplay.setText(Double.toString(result));
                currentOperator = "";
                waitingForOperand = true;
            } catch (RuntimeException e) {
                calculatorDisplay.setText("Error");
                currentNumber = 0;
                currentOperator = "";
                waitingForOperand = true;
            }
        }
    }

    /**
     * Handles clear button clicks to reset the calculator to its initial state.
     *
     * @param calculatorDisplay the label displaying the current calculator value
     */
    public void handleClearClick (Label calculatorDisplay) {
        calculatorDisplay.setText("0");
        currentNumber = 0;
        currentOperator = "";
        waitingForOperand = false;
    }

    /**
     * Handles keyboard input events for better user interaction.
     *
     * <p>Supported keyboard inputs:
     * <ul>
     *     <li>Numbers 0-9: equivalent to clicking number buttons</li>
     *     <li>Operators (+, -, *, /): equivalent to clicking operator buttons</li>
     *     <li>Equals (=): equivalent to clicking the equals button</li>
     *     <li>Delete key: equivalent to clicking the clear button</li>
     * </ul>
     *
     * @param keyEvent they keyboard event containing the pressed key information
     * @param calculatorDisplay the label displaying the current calculator value
     */
    public void handleKeyPressed(KeyEvent keyEvent, Label calculatorDisplay) {
        String text = keyEvent.getText();
        KeyCode code = keyEvent.getCode();

        switch (text) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                appendToDisplay(text, calculatorDisplay);
                break;
            case "+":
                processOperator("+", calculatorDisplay);
                break;
            case "-":
                processOperator("-", calculatorDisplay);
                break;
            case "*":
                processOperator("X", calculatorDisplay);
                break;
            case "/":
                processOperator("/", calculatorDisplay);
                break;
            case "=":
                handleEqualsClick(calculatorDisplay);
                break;
            default:
                break;
        }

        if (Objects.requireNonNull(code) == KeyCode.DELETE) {
            handleClearClick(calculatorDisplay);
        }
    }
}
