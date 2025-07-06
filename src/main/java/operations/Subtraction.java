package operations;

/**
 * Implementation of the addition operation for the calculator application.
 *
 * @Author Omar Mahmoud
 * @see Operation
 */
public class Subtraction implements Operation {
    /**
     *
     * @param firstNumber the first operand in the subtraction operation
     * @param secondNumber the second operand in the subtraction operation
     * @return the result of subtracting the secondNumber from the firstNumber
     */
    public double calculate(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }
}
