package engine;

import operations.Operation;
import operations.OperationsFactory;

/**
 * Core calculation engine for the calculator application.
 *
 * <p>The engine uses a factory pattern to obtain operation instances based on the provided operation symbol.</p>
 *
 * <p>Supported operations are determined by the {@link OperationsFactory}.</p>
 *
 * @Author Omar Mahmoud
 * @see Operation
 * @see OperationsFactory
 */
public class CalculatorEngine {

    /**
     * Constructs a new calculator engine instance.
     */
    public CalculatorEngine() {}

    /**
     * Performs a mathematical operation based on the specified operation and operands.
     *
     * <p>This method is the main entry point for all calculations in the calculator application.
     * It uses the factory patterns to obtation the appropriate operation based on the provided symbol.</p>
     *
     * @param operationSymbol the mathematical operator symbol ("+", "-", "*", "/")
     * @param firstNumber the first operand in the calculation
     * @param secondNumber the second operand in the calculation
     * @return the result of the mathematical operation
     */
    public double calculate(String operationSymbol, double firstNumber, double secondNumber) {
        Operation operation = OperationsFactory.getOperation(operationSymbol);
        return operation.calculate(firstNumber, secondNumber);
    }
}
