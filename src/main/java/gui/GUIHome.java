package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Main GUI application class for the calculator application.
 *
 * <p>The calculator GUI features:
 * <ul>
 *     <li>A digital display showing current numbers and results</li>
 *     <li>Number buttons (0-9) for numeric input</li>
 *     <li>Operator buttons (+, -, X, /) for mathematical operations</li>
 *     <li>Clear button (C) for resetting the calculator</li>
 *     <li>Equals button (=) for executing calculations</li>
 *     <li>Keyboard support for enhanced user interaction</li>
 *     <li>Custom CSS styling for improved visual appearance</li>
 * </ul>
 *
 * @Author Omar Mahmoud
 * @see CalculatorManager
 */
public class GUIHome extends Application {

    /**
     * The calculator manager instance responsible for handling all the calculator logic and state management.
     */
    private final CalculatorManager calculatorManager = new CalculatorManager();

    /**
     * The main display label showing the current number, calculation reuslt, and user input.
     */
    private Label calculatorDisplay;

    /**
     * The main entry point for the JavaFX application.
     *
     * @param args command line arguments passed to the application
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes and starts the JavaFX application.
     *
     * @param stage the primary stage provided by the JavaFX runtime
     *
     * @see #initializeCalculator()
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Calculator");

        StackPane root = new StackPane();

        root.getChildren().add(initializeCalculator());

        Scene scene = new Scene(root, 300, 320);
        scene.getStylesheets().add(getClass().getResource("/gui/styles.css").toExternalForm());
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            calculatorManager.handleKeyPressed(event, calculatorDisplay);
        });

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Initializes and constructs the complete calculator user interface.
     *
     * @return the main VBox container containing the complete calculator interface
     *
     * @see #createNumberButton(String)
     * @see #createOperatorButton(String)
     * @see #createClearButton()
     * @see #createEqualButton()
     */
    private VBox initializeCalculator() {
        Button add = createOperatorButton("+");
        Button subtract = createOperatorButton("-");
        Button multiply = createOperatorButton("*");
        Button divide = createOperatorButton("/");
        Button clear = createClearButton();
        Button equal = createEqualButton();
        Button zero = createNumberButton("0");
        Button one = createNumberButton("1");
        Button two = createNumberButton("2");
        Button three = createNumberButton("3");
        Button four = createNumberButton("4");
        Button five = createNumberButton("5");
        Button six = createNumberButton("6");
        Button seven = createNumberButton("7");
        Button eight = createNumberButton("8");
        Button nine = createNumberButton("9");

        HBox firstRow = new HBox();
        HBox secondRow = new HBox();
        HBox thirdRow = new HBox();
        HBox fourthRow = new HBox();

        firstRow.getChildren().addAll(seven, eight, nine, add);
        secondRow.getChildren().addAll(four, five, six, subtract);
        thirdRow.getChildren().addAll(one, two, three, multiply);
        fourthRow.getChildren().addAll(clear, zero, equal, divide);

        calculatorDisplay = new Label();
        calculatorDisplay.getStyleClass().add("display-label");
        calculatorDisplay.setText("0");
        calculatorDisplay.setPrefWidth(Double.MAX_VALUE);
        calculatorDisplay.setPrefHeight(100);

        VBox root = new VBox();
        root.getChildren().addAll(calculatorDisplay, firstRow, secondRow, thirdRow, fourthRow);

        return root;
    }

    /**
     * Creates a number button with standardized styling and behavior.
     *
     * @param text the number to display on the button
     * @return a number button ready to use
     */
    private Button createNumberButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(80);
        button.setPrefHeight(55);
        button.setPadding(new Insets(10));
        button.getStyleClass().add("number-button");
        button.setOnAction(event -> {calculatorManager.handleNumberClick(button, calculatorDisplay);});
        button.requestFocus();
        return button;
    }

    /**
     * Creates an operator button with standardized styling and behavior.
     *
     * @param text the operator symbol to display on the button
     * @return an operator button ready to use
     */
    private Button createOperatorButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(80);
        button.setPrefHeight(55);
        button.setPadding(new Insets(10));
        button.getStyleClass().add("operator-button");
        button.setOnAction(event -> {calculatorManager.handleOperatorClick(button, calculatorDisplay);});
        button.requestFocus();
        return button;
    }

    /**
     * Creates a clear button with standardized styling and behavior.
     *
     * @return a clear button ready to use
     */
    private Button createClearButton() {
        Button button = new Button("C");
        button.setPrefWidth(80);
        button.setPrefHeight(55);
        button.setPadding(new Insets(10));
        button.getStyleClass().add("clear-button");
        button.setOnAction(event -> {calculatorManager.handleClearClick(calculatorDisplay);});
        button.requestFocus();
        return button;
    }

    /**
     * Creates an equals button with standardized styling and behavior.
     *
     * @return an equals button ready to use
     */
    private Button createEqualButton() {
        Button button = new Button("=");
        button.setPrefWidth(80);
        button.setPrefHeight(55);
        button.setPadding(new Insets(10));
        button.getStyleClass().add("operator-button");
        button.setOnAction(event -> calculatorManager.handleEqualsClick(calculatorDisplay));
        button.requestFocus();
        return button;
    }
}
