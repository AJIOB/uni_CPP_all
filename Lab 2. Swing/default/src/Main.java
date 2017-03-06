import view.MainFrame;

import javax.swing.*;

/**
 * Created by Alex on 21.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}
