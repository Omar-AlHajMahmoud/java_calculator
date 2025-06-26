package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Home extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Calculator");

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 400);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
