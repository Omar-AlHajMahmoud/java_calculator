package operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Division operation.
 * Tests various scenarios including division by zero, positive numbers, negative numbers, and edge cases.
 */
public class DivisionTest {

    private Division division;

    @BeforeEach
    void setUp() {
        division = new Division();
    }

    @Test
    @DisplayName("Should divide two positive numbers correctly")
    void testDividePositiveNumbers() {
        assertEquals(2.0, division.calculate(6.0, 3.0), 0.001);
        assertEquals(0.5, division.calculate(1.0, 2.0), 0.001);
    }

    @Test
    @DisplayName("Should divide two negative numbers correctly")
    void testDivideNegativeNumbers() {
        assertEquals(2.0, division.calculate(-6.0, -3.0), 0.001);
        assertEquals(0.5, division.calculate(-1.0, -2.0), 0.001);
    }

    @Test
    @DisplayName("Should divide positive and negative numbers correctly")
    void testDividePositiveAndNegativeNumbers() {
        assertEquals(-2.0, division.calculate(6.0, -3.0), 0.001);
        assertEquals(-0.5, division.calculate(-1.0, 2.0), 0.001);
    }

    @Test
    @DisplayName("Should handle division by zero")
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            division.calculate(5.0, 0.0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    @DisplayName("Should handle zero divided by any number")
    void testZeroDividedByNumber() {
        assertEquals(0.0, division.calculate(0.0, 5.0), 0.001);
        assertEquals(0.0, division.calculate(0.0, -5.0), 0.001);
    }

    @Test
    @DisplayName("Should handle decimal numbers correctly")
    void testDivideDecimalNumbers() {
        assertEquals(2.5, division.calculate(5.0, 2.0), 0.001);
        assertEquals(0.333333, division.calculate(1.0, 3.0), 0.000001);
    }

    @Test
    @DisplayName("Should handle large numbers correctly")
    void testDivideLargeNumbers() {
        assertEquals(2.0, division.calculate(1000000.0, 500000.0), 0.001);
        assertEquals(0.5, division.calculate(5.0E9, 1.0E10), 0.001);
    }

    @Test
    @DisplayName("Should handle very small numbers correctly")
    void testDivideSmallNumbers() {
        assertEquals(2.0, division.calculate(0.000002, 0.000001), 0.001);
    }

    @Test
    @DisplayName("Should handle division with very small numbers")
    void testDivideWithVerySmallNumbers() {
        double result = division.calculate(1.0, 0.0000000000000001);
        assertTrue(result > 1.0E15); // Should be a very large number
    }
} 