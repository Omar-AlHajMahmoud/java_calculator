package engine;

import operations.BinaryOperation;
import operations.UnaryOperation;

/**
 * @Author Omar Mahmoud
 */
public class CalculatorEngine {

    public CalculatorEngine() {}

    /**
     *
     * @param binaryOperation
     * @param number_1
     * @param number_2
     * @return
     */
    public double calculate(BinaryOperation binaryOperation, double number_1, double number_2) {
        return binaryOperation.calculate(number_1, number_2);
    }

    /**
     *
     * @param unaryOperation
     * @param number_1
     * @return
     */
    public double calculate(UnaryOperation unaryOperation, double number_1) {
        return unaryOperation.calculate(number_1);
    }
}
