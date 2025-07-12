package operations;

/**
 * Implementation of the addition operation for the calculator application.
 *
 * @Author Omar Mahmoud
 * @see Operation
 */
public class Addition implements Operation {
    /**
     * Performs addition of two numbers.
     *
     * @param firstNumber the first operand in the addition operation
     * @param secondNumber the second operand in the addition operation
     * @return the sum of the firstNumber and the secondNumber
     */
    @Override
    public double calculate(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }
}
