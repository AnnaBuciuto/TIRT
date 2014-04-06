package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Window extends JFrame {


    public final JButton loadMapButton;
    public final JButton runAlgorithmsButton;
    final JPanel buttonsPanel;
    private final ButtonGroup radioButtonGroup;
    final JRadioButton radioButton1;
    final JRadioButton radioButton2;
    private final JLabel frequencyLabel;


    public Window(String title, ActionListener listener) {
        super(title);
        setBounds(20, 20, 1000, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        buttonsPanel = new JPanel();
        buttonsPanel.setBounds(800, 0, 192, 670);
        buttonsPanel.setBackground(Color.lightGray);
        buttonsPanel.setLayout(null);
        add(buttonsPanel);

        loadMapButton = new JButton("Load map file");
        loadMapButton.setBounds(10, 10, 170, 30);
        loadMapButton.addActionListener(listener);

        frequencyLabel = new JLabel("Choose frequency:");
        frequencyLabel.setBounds(10, 50, 170, 20);

        radioButton1 = new JRadioButton("2,4 GHz");
        radioButton1.setSelected(true);
        radioButton1.setBounds(10, 70, 170, 20);
        radioButton2 = new JRadioButton("5,0 GHz");
        radioButton2.setBounds(10, 90, 170, 20);
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButton1);
        radioButtonGroup.add(radioButton2);

        runAlgorithmsButton = new JButton("Run algorithms");
        runAlgorithmsButton.setBounds(10, 130, 170, 30);
        runAlgorithmsButton.addActionListener(listener);

        buttonsPanel.add(loadMapButton);
        buttonsPanel.add(frequencyLabel);
        buttonsPanel.add(radioButton1);
        buttonsPanel.add(radioButton2);
        buttonsPanel.add(runAlgorithmsButton);


    }


}
