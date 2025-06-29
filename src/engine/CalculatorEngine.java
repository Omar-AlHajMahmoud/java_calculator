package engine;

import operations.Operation;

/**
 * @Author Omar Mahmoud
 */
public class CalculatorEngine {

    public CalculatorEngine() {}

    /**
     *
     * @param operation
     * @param number_1
     * @param number_2
     * @return
     */
    public double calculate(Operation operation, double number_1, double number_2) {
        return operation.calculate(number_1, number_2);
    }
}
