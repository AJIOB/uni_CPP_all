package AJIOB.view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by AJIOB on 21.03.2017.
 *
 * @author AJIOB
 */
public class MainScene extends Scene {

    public MainScene() {
        super(makeRoot());
    }

    /**
     * Make main content of scene
     *
     * @return Root node to new scene
     */
    private static Parent makeRoot() {
        VBox root = new VBox();


        //TODO

        return root;
    }

    private static Parent makeSizeBlock() {
        HBox root = new HBox();

        Label textInfo = new Label("SIze of vectors:");

        //todo

        return root;
    }
}
