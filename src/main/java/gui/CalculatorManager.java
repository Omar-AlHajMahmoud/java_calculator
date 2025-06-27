package gui;

public class CalculatorManager {
    public void handleNumberInput(double number, double[] numbers) {
        if (numbers[0] == 0) {
            numbers[0] = number;
        }

        if (numbers[1] == 0) {
            numbers[1] = number;
        }
    }

    public void handleOperatorInput(char operator) {

    }

    public void handleEqualInput() {

    }
}
