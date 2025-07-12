package operations;

import java.util.HashMap;
import java.util.Map;

/**
 * This class allows for dynamic operation selection based on the operator, eliminating the need for complex switch and
 * if statements.
 *
 * @Author Omar Mahmoud
 */
public class OperationsFactory {
    private static final Map<String, Operation> operations = new HashMap<>();

    static {
        operations.put("+", new Addition());
        operations.put("-", new Subtraction());
        operations.put("*", new Multiplication());
        operations.put("/", new Division());
    }

    private OperationsFactory() {}

    /**
     *
     * @param operation the operation symbol to be mapped to an operation
     * @return the operation represented by the operation symbol
     */
    public static Operation getOperation(String operation) {
        Operation operationMapped = operations.get(operation);
        if (operationMapped == null) {
            throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
        return operationMapped;
    }
}
