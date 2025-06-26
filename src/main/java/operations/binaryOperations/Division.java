package operations.binaryOperations;

import operations.BinaryOperation;

/**
 * @Author Omar Mahmoud
 */
public class Division implements BinaryOperation {
    /**
     *
     * @param number_1
     * @param number_2
     * @return
     */
    public double calculate(double number_1, double number_2) {
        return number_1 / number_2;
    }
}
