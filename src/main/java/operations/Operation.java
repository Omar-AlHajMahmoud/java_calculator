package operations;

/**
 * Interface defining the contract for mathematical operations in the calculator application.
 *
 * <p>This interface follows the strategy pattern.</p>
 *
 * @Author Omar Mahmoud
 * @see Addition
 * @see Subtraction
 * @see Multiplication
 * @see Division
 */
public interface Operation {
     /**
      * Performs a mathematical operation using two operands.
      *
      * @param firstNumber the first operand
      * @param secondNumber the second operand
      * @return the result of the mathematical operation applied to the two operands
      */
     double calculate(double firstNumber, double secondNumber);
}
