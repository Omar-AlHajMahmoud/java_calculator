package operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Multiplication operation.
 * Tests various scenarios including positive numbers, negative numbers, zero, and edge cases.
 */
public class MultiplicationTest {

    private Multiplication multiplication;

    @BeforeEach
    void setUp() {
        multiplication = new Multiplication();
    }

    @Test
    @DisplayName("Should multiply two positive numbers correctly")
    void testMultiplyPositiveNumbers() {
        assertEquals(6.0, multiplication.calculate(2.0, 3.0), 0.001);
        assertEquals(23.76, multiplication.calculate(7.2, 3.3), 0.001);
    }

    @Test
    @DisplayName("Should multiply two negative numbers correctly")
    void testMultiplyNegativeNumbers() {
        assertEquals(6.0, multiplication.calculate(-2.0, -3.0), 0.001);
        assertEquals(23.76, multiplication.calculate(-7.2, -3.3), 0.001);
    }

    @Test
    @DisplayName("Should multiply positive and negative numbers correctly")
    void testMultiplyPositiveAndNegativeNumbers() {
        assertEquals(-6.0, multiplication.calculate(2.0, -3.0), 0.001);
        assertEquals(-6.0, multiplication.calculate(-2.0, 3.0), 0.001);
    }

    @Test
    @DisplayName("Should multiply with zero correctly")
    void testMultiplyWithZero() {
        assertEquals(0.0, multiplication.calculate(5.0, 0.0), 0.001);
        assertEquals(0.0, multiplication.calculate(0.0, 5.0), 0.001);
        assertEquals(0.0, multiplication.calculate(0.0, 0.0), 0.001);
    }

    @Test
    @DisplayName("Should handle decimal numbers correctly")
    void testMultiplyDecimalNumbers() {
        assertEquals(6.28318, multiplication.calculate(3.14159, 2.0), 0.00001);
        assertEquals(0.01, multiplication.calculate(0.1, 0.1), 0.001);
    }

    @Test
    @DisplayName("Should handle large numbers correctly")
    void testMultiplyLargeNumbers() {
        assertEquals(1.0E12, multiplication.calculate(1.0E6, 1.0E6), 0.001);
        assertEquals(2.5E19, multiplication.calculate(5.0E9, 5.0E9), 0.001);
    }

    @Test
    @DisplayName("Should handle very small numbers correctly")
    void testMultiplySmallNumbers() {
        assertEquals(1.0E-12, multiplication.calculate(1.0E-6, 1.0E-6), 0.001);
    }

    @Test
    @DisplayName("Should handle one correctly")
    void testMultiplyWithOne() {
        assertEquals(5.0, multiplication.calculate(5.0, 1.0), 0.001);
        assertEquals(5.0, multiplication.calculate(1.0, 5.0), 0.001);
    }
} 