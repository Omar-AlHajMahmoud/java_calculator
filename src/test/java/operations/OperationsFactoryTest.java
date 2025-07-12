package operations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the OperationsFactory.
 * Tests the factory pattern implementation and error handling.
 */
public class OperationsFactoryTest {

    @Test
    @DisplayName("Should return Addition operation for '+' symbol")
    void testGetAdditionOperation() {
        Operation operation = OperationsFactory.getOperation("+");
        assertNotNull(operation);
        assertTrue(operation instanceof Addition);
        assertEquals(5.0, operation.calculate(2.0, 3.0), 0.001);
    }

    @Test
    @DisplayName("Should return Subtraction operation for '-' symbol")
    void testGetSubtractionOperation() {
        Operation operation = OperationsFactory.getOperation("-");
        assertNotNull(operation);
        assertTrue(operation instanceof Subtraction);
        assertEquals(-1.0, operation.calculate(2.0, 3.0), 0.001);
    }

    @Test
    @DisplayName("Should return Multiplication operation for '*' symbol")
    void testGetMultiplicationOperation() {
        Operation operation = OperationsFactory.getOperation("*");
        assertNotNull(operation);
        assertTrue(operation instanceof Multiplication);
        assertEquals(6.0, operation.calculate(2.0, 3.0), 0.001);
    }

    @Test
    @DisplayName("Should return Division operation for '/' symbol")
    void testGetDivisionOperation() {
        Operation operation = OperationsFactory.getOperation("/");
        assertNotNull(operation);
        assertTrue(operation instanceof Division);
        assertEquals(0.666667, operation.calculate(2.0, 3.0), 0.000001);
    }

    @Test
    @DisplayName("Should throw exception for unsupported operation")
    void testGetUnsupportedOperation() {
        assertThrows(IllegalArgumentException.class, () -> {
            OperationsFactory.getOperation("X");
        });
    }

    @Test
    @DisplayName("Should throw exception for null operation")
    void testGetNullOperation() {
        assertThrows(IllegalArgumentException.class, () -> {
            OperationsFactory.getOperation(null);
        });
    }

    @Test
    @DisplayName("Should throw exception for empty string operation")
    void testGetEmptyStringOperation() {
        assertThrows(IllegalArgumentException.class, () -> {
            OperationsFactory.getOperation("");
        });
    }

    @Test
    @DisplayName("Should throw exception for invalid operation symbols")
    void testGetInvalidOperationSymbols() {
        assertThrows(IllegalArgumentException.class, () -> {
            OperationsFactory.getOperation("++");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            OperationsFactory.getOperation("add");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            OperationsFactory.getOperation("1");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            OperationsFactory.getOperation(" ");
        });
    }
} 