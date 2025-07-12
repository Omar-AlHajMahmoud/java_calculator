package gui;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the CalculatorManager.
 * Tests GUI logic, state management, and user interaction handling.
 */
public class CalculatorManagerTest {

    private CalculatorManager calculatorManager;
    private Label mockDisplay;

    @BeforeAll
    static void initJFX() {
        // Initialize JavaFX toolkit for testing
        new JFXPanel();
    }

    @BeforeEach
    void setUp() {
        calculatorManager = new CalculatorManager();
        mockDisplay = new Label("0");
    }

    @Test
    @DisplayName("Should handle number click correctly")
    void testHandleNumberClick() {
        Button button = new Button("5");
        calculatorManager.handleNumberClick(button, mockDisplay);
        assertEquals("5", mockDisplay.getText());
    }

    @Test
    @DisplayName("Should append numbers correctly")
    void testAppendNumbers() {
        // First number
        Button button1 = new Button("1");
        calculatorManager.handleNumberClick(button1, mockDisplay);
        assertEquals("1", mockDisplay.getText());

        // Second number
        Button button2 = new Button("2");
        calculatorManager.handleNumberClick(button2, mockDisplay);
        assertEquals("12", mockDisplay.getText());
    }

    @Test
    @DisplayName("Should handle operator click correctly")
    void testHandleOperatorClick() {
        // Set up initial number
        Button numberButton = new Button("5");
        calculatorManager.handleNumberClick(numberButton, mockDisplay);

        // Click operator
        Button operatorButton = new Button("+");
        calculatorManager.handleOperatorClick(operatorButton, mockDisplay);
        
        // Display should still show 5, but calculator is waiting for second operand
        assertEquals("5", mockDisplay.getText());
    }

    @Test
    @DisplayName("Should perform calculation when equals is clicked")
    void testHandleEqualsClick() {
        // Set up: 5 + 3
        Button number1 = new Button("5");
        calculatorManager.handleNumberClick(number1, mockDisplay);

        Button operator = new Button("+");
        calculatorManager.handleOperatorClick(operator, mockDisplay);

        Button number2 = new Button("3");
        calculatorManager.handleNumberClick(number2, mockDisplay);

        // Click equals
        calculatorManager.handleEqualsClick(mockDisplay);
        assertEquals("8.0", mockDisplay.getText());
    }

    @Test
    @DisplayName("Should handle clear click correctly")
    void testHandleClearClick() {
        // Set up some state
        Button number = new Button("5");
        calculatorManager.handleNumberClick(number, mockDisplay);
        assertEquals("5", mockDisplay.getText());

        // Clear
        calculatorManager.handleClearClick(mockDisplay);
        assertEquals("0", mockDisplay.getText());
    }

    @Test
    @DisplayName("Should handle keyboard number input")
    void testHandleKeyPressedNumbers() {
        KeyEvent keyEvent = createKeyEvent("5");
        calculatorManager.handleKeyPressed(keyEvent, mockDisplay);
        assertEquals("5", mockDisplay.getText());
    }

    @Test
    @DisplayName("Should handle keyboard operator input")
    void testHandleKeyPressedOperators() {
        // Set up initial number
        KeyEvent numberKey = createKeyEvent("5");
        calculatorManager.handleKeyPressed(numberKey, mockDisplay);

        // Press operator key
        KeyEvent operatorKey = createKeyEvent("+");
        calculatorManager.handleKeyPressed(operatorKey, mockDisplay);
        
        assertEquals("5", mockDisplay.getText());
    }

    @Test
    @DisplayName("Should handle keyboard equals input")
    void testHandleKeyPressedEquals() {
        // Set up: 5 + 3
        KeyEvent key5 = createKeyEvent("5");
        calculatorManager.handleKeyPressed(key5, mockDisplay);

        KeyEvent keyPlus = createKeyEvent("+");
        calculatorManager.handleKeyPressed(keyPlus, mockDisplay);

        KeyEvent key3 = createKeyEvent("3");
        calculatorManager.handleKeyPressed(key3, mockDisplay);

        // Press equals
        KeyEvent keyEquals = createKeyEvent("=");
        calculatorManager.handleKeyPressed(keyEquals, mockDisplay);
        
        assertEquals("8.0", mockDisplay.getText());
    }

    @Test
    @DisplayName("Should handle keyboard delete key")
    void testHandleKeyPressedDelete() {
        // Set up some state
        KeyEvent key5 = createKeyEvent("5");
        calculatorManager.handleKeyPressed(key5, mockDisplay);
        assertEquals("5", mockDisplay.getText());

        // Press delete
        KeyEvent deleteKey = createKeyEvent(KeyCode.DELETE);
        calculatorManager.handleKeyPressed(deleteKey, mockDisplay);
        
        assertEquals("0", mockDisplay.getText());
    }

    @Test
    @DisplayName("Should handle division by zero error")
    void testDivisionByZeroError() {
        // Set up: 5 / 0
        Button number1 = new Button("5");
        calculatorManager.handleNumberClick(number1, mockDisplay);

        Button operator = new Button("/");
        calculatorManager.handleOperatorClick(operator, mockDisplay);

        Button number2 = new Button("0");
        calculatorManager.handleNumberClick(number2, mockDisplay);

        // Click equals - should show error
        calculatorManager.handleEqualsClick(mockDisplay);
        assertEquals("Error", mockDisplay.getText());
    }

    @Test
    @DisplayName("Should handle consecutive operations")
    void testConsecutiveOperations() {
        // 5 + 3 + 2 = 10
        Button number1 = new Button("5");
        calculatorManager.handleNumberClick(number1, mockDisplay);

        Button operator1 = new Button("+");
        calculatorManager.handleOperatorClick(operator1, mockDisplay);

        Button number2 = new Button("3");
        calculatorManager.handleNumberClick(number2, mockDisplay);

        Button operator2 = new Button("+");
        calculatorManager.handleOperatorClick(operator2, mockDisplay);

        Button number3 = new Button("2");
        calculatorManager.handleNumberClick(number3, mockDisplay);

        calculatorManager.handleEqualsClick(mockDisplay);
        assertEquals("10.0", mockDisplay.getText());
    }

    // Helper method to create KeyEvent for testing
    private KeyEvent createKeyEvent(String text) {
        return new KeyEvent(
            KeyEvent.KEY_PRESSED,
            text,
            text,
            KeyCode.UNDEFINED,
            false, false, false, false
        );
    }

    private KeyEvent createKeyEvent(KeyCode keyCode) {
        return new KeyEvent(
            KeyEvent.KEY_PRESSED,
            "",
            "",
            keyCode,
            false, false, false, false
        );
    }
} 