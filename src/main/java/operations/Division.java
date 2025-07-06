package operations;

/**
 * Implementation of the addition operation for the calculator application.
 *
 * @Author Omar Mahmoud
 * @see Operation
 */
public class Division implements Operation {
    /**
     *
     * @param firstNumber the first operand in the division operation
     * @param secondNumber the second operand in the division operation
     * @return the result of dividing the first number by the second number
     */
    public double calculate(double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }
}
