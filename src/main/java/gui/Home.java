package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Home extends Application {

    private final CalculatorManager calculatorManager = new CalculatorManager();

    private TextArea textArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Calculator");

        StackPane root = new StackPane();

        root.getChildren().add(initializeCalculator());

        Scene scene = new Scene(root, 300, 400);
        scene.getStylesheets().add(getClass().getResource("/gui/styles.css").toExternalForm());

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private VBox initializeCalculator() {
        Button add = createOperatorButton("+");
        Button subtract = createOperatorButton("-");
        Button multiply = createOperatorButton("X");
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

        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.getStyleClass().add("text-area");

        VBox root = new VBox();
        root.getChildren().addAll(textArea, firstRow, secondRow, thirdRow, fourthRow);

        return root;
    }

    private Button createNumberButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(80);
        button.setPrefHeight(55);
        button.setPadding(new Insets(10));
        button.getStyleClass().add("number-button");
        button.setOnAction(event -> {calculatorManager.handleNumberClick(button, textArea);});
        return button;
    }

    private Button createOperatorButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(80);
        button.setPrefHeight(55);
        button.setPadding(new Insets(10));
        button.getStyleClass().add("operator-button");
        button.setOnAction(event -> {calculatorManager.handleOperatorClick(button, textArea);});
        return button;
    }

    private Button createClearButton() {
        Button button = new Button("C");
        button.setPrefWidth(80);
        button.setPrefHeight(55);
        button.setPadding(new Insets(10));
        button.getStyleClass().add("clear-button");
        button.setOnAction(event -> {calculatorManager.handleClearClick(textArea);});
        return button;
    }

    private Button createEqualButton() {
        Button button = new Button("=");
        button.setPrefWidth(80);
        button.setPrefHeight(55);
        button.setPadding(new Insets(10));
        button.getStyleClass().add("operator-button");
        button.setOnAction(event -> calculatorManager.handleEqualsClick(textArea));
        return button;
    }
}
