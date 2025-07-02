package operations.binaryOperations;

import operations.Operation;

/**
 * @Author Omar Mahmoud
 */
public class Addition implements Operation {
    /**
     *
     * @param firstNumber
     * @param secondNumber
     * @return
     */
    @Override
    public double calculate(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }
}
