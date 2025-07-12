package operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Subtraction operation.
 * Tests various scenarios including positive numbers, negative numbers, zero, and edge cases.
 */
public class SubtractionTest {

    private Subtraction subtraction;

    @BeforeEach
    void setUp() {
        subtraction = new Subtraction();
    }

    @Test
    @DisplayName("Should subtract two positive numbers correctly")
    void testSubtractPositiveNumbers() {
        assertEquals(2.0, subtraction.calculate(5.0, 3.0), 0.001);
        assertEquals(3.9, subtraction.calculate(7.2, 3.3), 0.001);
    }

    @Test
    @DisplayName("Should subtract two negative numbers correctly")
    void testSubtractNegativeNumbers() {
        assertEquals(1.0, subtraction.calculate(-2.0, -3.0), 0.001);
        assertEquals(-3.9, subtraction.calculate(-7.2, -3.3), 0.001);
    }

    @Test
    @DisplayName("Should subtract positive and negative numbers correctly")
    void testSubtractPositiveAndNegativeNumbers() {
        assertEquals(7.0, subtraction.calculate(4.0, -3.0), 0.001);
        assertEquals(-7.0, subtraction.calculate(-4.0, 3.0), 0.001);
    }

    @Test
    @DisplayName("Should subtract zero correctly")
    void testSubtractWithZero() {
        assertEquals(5.0, subtraction.calculate(5.0, 0.0), 0.001);
        assertEquals(-5.0, subtraction.calculate(0.0, 5.0), 0.001);
        assertEquals(0.0, subtraction.calculate(0.0, 0.0), 0.001);
    }

    @Test
    @DisplayName("Should handle decimal numbers correctly")
    void testSubtractDecimalNumbers() {
        assertEquals(0.85841, subtraction.calculate(3.14159, 2.28318), 0.00001);
        assertEquals(0.0, subtraction.calculate(0.1, 0.1), 0.001);
    }

    @Test
    @DisplayName("Should handle large numbers correctly")
    void testSubtractLargeNumbers() {
        assertEquals(0.0, subtraction.calculate(1000000.0, 1000000.0), 0.001);
        assertEquals(5.0E9, subtraction.calculate(1.0E10, 5.0E9), 0.001);
    }

    @Test
    @DisplayName("Should handle very small numbers correctly")
    void testSubtractSmallNumbers() {
        assertEquals(0.0, subtraction.calculate(0.000001, 0.000001), 0.000001);
    }
} 