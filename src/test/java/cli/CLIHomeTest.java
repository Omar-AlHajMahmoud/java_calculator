package cli;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the CLI functionality.
 * Tests input validation and calculation logic.
 */
public class CLIHomeTest {

    @Test
    @DisplayName("Should validate valid operators correctly")
    void testValidOperators() {
        assertTrue(CLIHome.isValidOperator('+'));
        assertTrue(CLIHome.isValidOperator('-'));
        assertTrue(CLIHome.isValidOperator('*'));
        assertTrue(CLIHome.isValidOperator('/'));
    }

    @Test
    @DisplayName("Should reject invalid operators")
    void testInvalidOperators() {
        assertFalse(CLIHome.isValidOperator('x'));
        assertFalse(CLIHome.isValidOperator('='));
        assertFalse(CLIHome.isValidOperator('1'));
        assertFalse(CLIHome.isValidOperator('a'));
        assertFalse(CLIHome.isValidOperator(' '));
    }

    @Test
    @DisplayName("Should perform addition calculation correctly")
    void testAdditionCalculation() {
        double result = CLIHome.performCalculation("+", 5.0, 3.0);
        assertEquals(8.0, result, 0.001);
    }

    @Test
    @DisplayName("Should perform subtraction calculation correctly")
    void testSubtractionCalculation() {
        double result = CLIHome.performCalculation("-", 5.0, 3.0);
        assertEquals(2.0, result, 0.001);
    }

    @Test
    @DisplayName("Should perform multiplication calculation correctly")
    void testMultiplicationCalculation() {
        double result = CLIHome.performCalculation("*", 5.0, 3.0);
        assertEquals(15.0, result, 0.001);
    }

    @Test
    @DisplayName("Should perform division calculation correctly")
    void testDivisionCalculation() {
        double result = CLIHome.performCalculation("/", 6.0, 2.0);
        assertEquals(3.0, result, 0.001);
    }

    @Test
    @DisplayName("Should handle division by zero error")
    void testDivisionByZeroError() {
        double result = CLIHome.performCalculation("/", 5.0, 0.0);
        assertEquals(Double.MIN_VALUE, result, 0.001);
    }

    @Test
    @DisplayName("Should handle decimal numbers correctly")
    void testDecimalNumbers() {
        double result = CLIHome.performCalculation("+", 1.5, 2.5);
        assertEquals(4.0, result, 0.001);
    }

    @Test
    @DisplayName("Should handle negative numbers correctly")
    void testNegativeNumbers() {
        double result = CLIHome.performCalculation("+", -5.0, 3.0);
        assertEquals(-2.0, result, 0.001);
    }
} 