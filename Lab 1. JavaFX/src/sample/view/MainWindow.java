package sample.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.Main;
import sample.model.Model;


/**
 * Created by Alex on 21.02.2017.
 */
public class MainWindow extends VBox {
    private Model model = new Model();

    /**
     * Main constructor
     */
    public MainWindow() {
        super();

        init();
    }

    /**
     * Initialising all components of main window
     */
    private void init() {
        getStylesheets().add(Main.class.getResource("styles/main.css").toExternalForm());
        getStyleClass().add("box");

        TextField inputField = new TextField("Input your number here...");

        Label infoField = new Label();

        HBox buttonBox = new HBox();

        buttonBox.getStylesheets().add(Main.class.getResource("styles/main.css").toExternalForm());
        buttonBox.getStyleClass().add("box");
        buttonBox.getStyleClass().add("buttonBox");

        Button divineButton = new Button("Угадать");
        Button newButton = new Button("Новое");

        buttonBox.getChildren().addAll(divineButton, newButton);

        getChildren().addAll(inputField, infoField, buttonBox);


        //set actions
        newButton.setOnAction(event -> {
            model.generateNewNumber();
            divineButton.setDisable(false);
        });

        inputField.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = inputField.getText().charAt(oldValue.intValue());
                    // Check if the new character is the number or other's
                    if (!(ch >= '0' && ch <= '9')) {
                        // if it's not number then just setText to previous one
                        inputField.setText(inputField.getText().substring(0, inputField.getText().length() - 1));
                    }
                }
            }

        });

        divineButton.setOnAction(event -> {
            int currentNum;

            try {
                currentNum = Integer.parseInt(inputField.getText());
            } catch (NumberFormatException e) {
                infoField.setText("Пожалуйста, введите число.");
                return;
            }

            int res = model.compare(currentNum);

            if (res == 0) {
                infoField.setText("Вы угадали число. Поздравляем!");
                divineButton.setDisable(true);
            } else if (res > 0) {
                infoField.setText("Ваше число больше загаданного.");
            } else {
                infoField.setText("Ваше число  меньше загаданного.");
            }
        });
    }


}
