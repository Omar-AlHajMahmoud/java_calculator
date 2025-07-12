package operations;

/**
 * Implementation of the addition operation for the calculator application.
 *
 * @Author Omar Mahmoud
 * @see Operation
 */
public class Multiplication implements Operation {
    /**
     * Performs multiplication of two numbers.
     *
     * @param firstNumber the first operand in the multiplication operation
     * @param secondNumber the second operand in the multiplication operation
     * @return the result of multiplying the first number by the second number
     */
    public double calculate(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }
}
