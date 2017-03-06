package view;

import model.Zoo;
import model.animal.Animal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * Created by Alex on 21.02.2017.
 */
public class MainFrame extends JFrame {
    private Zoo zoo;
    private JLabel infoLabel;

    public MainFrame() {
        super("Lab 2. Made by AJIOB");

        zoo = new Zoo();

        createAndShowGUI();
    }

    /**
     * Create and show main window
     */
    private void createAndShowGUI() {
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addContent(getContentPane());

        //pack();
        setVisible(true);
    }

    /**
     * Add all content to field
     *
     * @param pane Layout to add components
     */
    private void addContent(Container pane) {
        //todo: make me
        pane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);

        infoLabel = new JLabel("Hello, Alex");
        add(infoLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = GridBagConstraints.RELATIVE;

        //feed
        for (int i = 0; i < zoo.getAnimals().size(); ++i) {
            Animal currAnimal = zoo.getAnimals().get(i);
            JButton btn = new JButton("Feed " + currAnimal.getName());
            add(btn, gbc);

            int finalI = i;
            btn.addActionListener((ActionEvent actionEvent) -> {
                showInfo(zoo.getWorker().feedAnimal(finalI, "Apple"));
            });
        }

        gbc.gridy = 2;
        //clear
        for (int i = 0; i < zoo.getAnimals().size(); ++i) {
            Animal currAnimal = zoo.getAnimals().get(i);
            JButton btn = new JButton("Clear " + currAnimal.getName() + "'s cave");
            add(btn, gbc);

            int finalI = i;
            btn.addActionListener((ActionEvent actionEvent) -> {
                showInfo(zoo.getWorker().ClearAnimalCage(finalI));
            });
        }

        //new JButton("Feed elephant");


        //this.add(button);
/*
        button.addActionListener((ActionEvent ae) -> {
            button.setText("You pressed me");

            infoLabel.setText("You pressed button");
        });*/
    }

    private void showInfo(String s) {
        infoLabel.setText(s);
    }
}
