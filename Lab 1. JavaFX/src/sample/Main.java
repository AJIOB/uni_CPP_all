package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.view.MainWindow;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = new MainWindow();
        primaryStage.setTitle("Lab 1. Made by AJIOB");
        primaryStage.setScene(new Scene(root/*, 300, 275*/));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
