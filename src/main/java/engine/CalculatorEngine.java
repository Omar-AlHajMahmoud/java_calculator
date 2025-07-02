package engine;

import operations.Operation;

/**
 * @Author Omar Mahmoud
 */
public class CalculatorEngine {

    public CalculatorEngine() {}

    /**
     *
     * @param operation
     * @param firstNumber
     * @param secondNumber
     * @return
     */
    public double calculate(Operation operation, double firstNumber, double secondNumber) {
        return operation.calculate(firstNumber, secondNumber);
    }
}
