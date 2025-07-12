package operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Addition operation.
 * Tests various scenarios including positive numbers, negative numbers, zero, and edge cases.
 */
public class AdditionTest {

    private Addition addition;

    @BeforeEach
    void setUp() {
        addition = new Addition();
    }

    @Test
    @DisplayName("Should add two positive numbers correctly")
    void testAddPositiveNumbers() {
        assertEquals(5.0, addition.calculate(2.0, 3.0), 0.001);
        assertEquals(10.5, addition.calculate(7.2, 3.3), 0.001);
    }

    @Test
    @DisplayName("Should add two negative numbers correctly")
    void testAddNegativeNumbers() {
        assertEquals(-5.0, addition.calculate(-2.0, -3.0), 0.001);
        assertEquals(-10.5, addition.calculate(-7.2, -3.3), 0.001);
    }

    @Test
    @DisplayName("Should add positive and negative numbers correctly")
    void testAddPositiveAndNegativeNumbers() {
        assertEquals(1.0, addition.calculate(4.0, -3.0), 0.001);
        assertEquals(-1.0, addition.calculate(-4.0, 3.0), 0.001);
    }

    @Test
    @DisplayName("Should add zero correctly")
    void testAddWithZero() {
        assertEquals(5.0, addition.calculate(5.0, 0.0), 0.001);
        assertEquals(5.0, addition.calculate(0.0, 5.0), 0.001);
        assertEquals(0.0, addition.calculate(0.0, 0.0), 0.001);
    }

    @Test
    @DisplayName("Should handle decimal numbers correctly")
    void testAddDecimalNumbers() {
        assertEquals(3.14159, addition.calculate(1.14159, 2.0), 0.00001);
        assertEquals(0.1, addition.calculate(0.05, 0.05), 0.001);
    }

    @Test
    @DisplayName("Should handle large numbers correctly")
    void testAddLargeNumbers() {
        assertEquals(2000000.0, addition.calculate(1000000.0, 1000000.0), 0.001);
        assertEquals(1.0E10, addition.calculate(5.0E9, 5.0E9), 0.001);
    }

    @Test
    @DisplayName("Should handle very small numbers correctly")
    void testAddSmallNumbers() {
        assertEquals(0.000002, addition.calculate(0.000001, 0.000001), 0.000001);
    }
} 