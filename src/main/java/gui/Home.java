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
import operations.BinaryOperation;
import operations.binaryOperations.*;
import operations.unaryOperations.SquareRoot;

public class Home extends Application {

    private double number_1, number_2;
    private String currentOperator;
    private boolean number1_is_empty = true;
    private boolean number2_is_empty = true;

    CalculatorManager calculatorManager = new CalculatorManager();
    Addition addition = new Addition();
    Subtraction subtraction = new Subtraction();
    Multiplication multiplication = new Multiplication();
    Division division = new Division();
    Power power = new Power();
    Modulus modulus = new Modulus();
    SquareRoot squareRoot = new SquareRoot();

    private TextArea textArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Calculator");

        StackPane root = new StackPane();

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));

        textArea = new TextArea();
        textArea.setEditable(false);

        HBox firstRow = new HBox();
        firstRow.setSpacing(10);
        firstRow.setPadding(new Insets(10));

        Button seven = new Button("7");
        seven.setPrefWidth(60);
        seven.setOnAction(e -> {appendNumber("7");});
        Button eight = new Button("8");
        eight.setPrefWidth(60);
        eight.setOnAction(e -> {appendNumber("8");});
        Button nine = new Button("9");
        nine.setPrefWidth(60);
        nine.setOnAction(e -> {appendNumber("9");});
        Button multiply = new Button("X");
        multiply.setPrefWidth(60);
        multiply.setOnAction(e -> {setOperator("*");});
        multiply.setOnAction(e -> {textArea.appendText("X");});

        firstRow.getChildren().addAll(seven, eight, nine, multiply);

        HBox secondRow = new HBox();
        secondRow.setSpacing(10);
        secondRow.setPadding(new Insets(10));

        Button four = new Button("4");
        four.setPrefWidth(60);
        four.setOnAction(e -> {appendNumber("4");});
        Button five = new Button("5");
        five.setPrefWidth(60);
        five.setOnAction(e -> {appendNumber("5");});
        Button six = new Button("6");
        six.setPrefWidth(60);
        six.setOnAction(e -> {appendNumber("6");});
        Button minus = new Button("-");
        minus.setPrefWidth(60);
        minus.setOnAction(e -> {setOperator("-");});
        minus.setOnAction(e -> {textArea.appendText("-");});

        secondRow.getChildren().addAll(four, five, six, minus);

        HBox thirdRow = new HBox();
        thirdRow.setSpacing(10);
        thirdRow.setPadding(new Insets(10));

        Button one = new Button("1");
        one.setPrefWidth(60);
        one.setOnAction(e -> {appendNumber("1");});
        Button two = new Button("2");
        two.setPrefWidth(60);
        two.setOnAction(e -> {appendNumber("2");});
        Button three = new Button("3");
        three.setPrefWidth(60);
        three.setOnAction(e -> {appendNumber("3");});
        Button add = new Button("+");
        add.setPrefWidth(60);
        add.setOnAction(e -> {setOperator("+");});
        add.setOnAction(e -> {textArea.appendText("+");});

        thirdRow.getChildren().addAll(one, two, three, add);

        HBox fourthRow = new HBox();
        fourthRow.setSpacing(10);
        fourthRow.setPadding(new Insets(10));

        Button divide = new Button("/");
        divide.setPrefWidth(60);
        divide.setOnAction(e -> {setOperator("/");});
        divide.setOnAction(e -> {textArea.appendText("/");});
        Button zero = new Button("0");
        zero.setPrefWidth(60);
        zero.setOnAction(e -> {appendNumber("0");});
        Button dot = new Button(".");
        dot.setPrefWidth(60);
        dot.setOnAction(e -> {textArea.appendText(".");});
        Button equal = new Button("=");
        equal.setPrefWidth(60);
        equal.setOnAction(e -> {calculate(number_1, number_2);});

        fourthRow.getChildren().addAll(divide, zero, dot, equal);

        HBox fifthRow = new HBox();
        fifthRow.setSpacing(10);
        fifthRow.setPadding(new Insets(10));

        vbox.getChildren().addAll(textArea, firstRow, secondRow, thirdRow, fourthRow, fifthRow);
        root.getChildren().add(vbox);

        Scene scene = new Scene(root, 300, 400);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void appendNumber(String number) {
        textArea.appendText(number);
        if (number1_is_empty) {
            number1_is_empty = false;
            number_1 = Double.parseDouble(number);
        } else if (number2_is_empty) {
            number2_is_empty = false;
            number_2 = Double.parseDouble(number);
        }
    }

    private void setOperator(String operator) {
        currentOperator = operator;
    }

    private void calculate(double number_1, double number_2) {
        double result = 0.0;
        switch (currentOperator) {
            case "+":
                result = addition.calculate(number_1, number_2);
                break;
            case "-":
                result = subtraction.calculate(number_1, number_2);
                break;
            case "*":
                result = multiplication.calculate(number_1, number_2);
                break;
            case "/":
                result = division.calculate(number_1, number_2);
                break;
            case "^":
                result = power.calculate(number_1, number_2);
                break;
            default:
                break;
        }
        textArea.appendText(Double.toString(result));
    }
}
