package engine;

import operations.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the CalculatorEngine.
 * Tests the core calculation logic and integration with operations.
 */
public class CalculatorEngineTest {

    private CalculatorEngine calculatorEngine;

    @BeforeEach
    void setUp() {
        calculatorEngine = new CalculatorEngine();
    }

    @Test
    @DisplayName("Should perform addition correctly")
    void testAddition() {
        double result = calculatorEngine.calculate("+", 5.0, 3.0);
        assertEquals(8.0, result, 0.001);
    }

    @Test
    @DisplayName("Should perform subtraction correctly")
    void testSubtraction() {
        double result = calculatorEngine.calculate("-", 5.0, 3.0);
        assertEquals(2.0, result, 0.001);
    }

    @Test
    @DisplayName("Should perform multiplication correctly")
    void testMultiplication() {
        double result = calculatorEngine.calculate("*", 5.0, 3.0);
        assertEquals(15.0, result, 0.001);
    }

    @Test
    @DisplayName("Should perform division correctly")
    void testDivision() {
        double result = calculatorEngine.calculate("/", 6.0, 2.0);
        assertEquals(3.0, result, 0.001);
    }

    @Test
    @DisplayName("Should handle division by zero")
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculatorEngine.calculate("/", 5.0, 0.0);
        });
    }

    @Test
    @DisplayName("Should handle unsupported operations")
    void testUnsupportedOperation() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorEngine.calculate("X", 5.0, 3.0);
        });
    }

    @Test
    @DisplayName("Should handle null operation")
    void testNullOperation() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorEngine.calculate(null, 5.0, 3.0);
        });
    }

    @Test
    @DisplayName("Should handle decimal numbers correctly")
    void testDecimalNumbers() {
        assertEquals(3.5, calculatorEngine.calculate("+", 1.2, 2.3), 0.001);
        assertEquals(2.76, calculatorEngine.calculate("*", 1.2, 2.3), 0.001);
    }

    @Test
    @DisplayName("Should handle negative numbers correctly")
    void testNegativeNumbers() {
        assertEquals(-2.0, calculatorEngine.calculate("+", -5.0, 3.0), 0.001);
        assertEquals(-8.0, calculatorEngine.calculate("-", -5.0, 3.0), 0.001);
        assertEquals(-15.0, calculatorEngine.calculate("*", -5.0, 3.0), 0.001);
    }

    @Test
    @DisplayName("Should handle zero correctly")
    void testZero() {
        assertEquals(5.0, calculatorEngine.calculate("+", 5.0, 0.0), 0.001);
        assertEquals(5.0, calculatorEngine.calculate("-", 5.0, 0.0), 0.001);
        assertEquals(0.0, calculatorEngine.calculate("*", 5.0, 0.0), 0.001);
    }
} 