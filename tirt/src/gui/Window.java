package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Window extends JFrame {


    public final JButton loadMapButton;
    public final JButton runAlgorithmsButton;
    final JPanel buttonsPanel;
    public final MapPanel mapPanel1, mapPanel2;
    public final JScrollPane scrollPane1;

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

        runAlgorithmsButton = new JButton("Run algorithms");
        runAlgorithmsButton.setBounds(10, 50, 170, 30);
        runAlgorithmsButton.addActionListener(listener);

        buttonsPanel.add(loadMapButton);
        buttonsPanel.add(runAlgorithmsButton);

        ImageSolver imageSolver = new ImageSolver();
        mapPanel1 = new MapPanel(imageSolver);
        mapPanel1.setLayout(null);
        mapPanel1.setBorder(BorderFactory.createLineBorder(Color.red));
        scrollPane1 = new JScrollPane(mapPanel1);
        scrollPane1.setBounds(0,0,800,670);
        scrollPane1.setViewportView(mapPanel1);
        add(scrollPane1);

        mapPanel2 = new MapPanel(imageSolver);
    }
}
