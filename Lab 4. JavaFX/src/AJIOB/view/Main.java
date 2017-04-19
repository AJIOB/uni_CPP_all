package AJIOB.view;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by AJIOB on 21.03.2017.
 *
 * @author AJIOB
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Calculating sum of vectors. Made by AJIOB");

        stage.setScene(new MainScene());

        stage.show();
    }
}
