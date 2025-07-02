package operations.binaryOperations;

import operations.Operation;

/**
 * @Author Omar Mahmoud
 */
public class Multiplication implements Operation {
    /**
     *
     * @param firstNumber
     * @param secondNumber
     * @return
     */
    public double calculate(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }
}
