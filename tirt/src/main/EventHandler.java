package main;

import gui.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EventHandler implements ActionListener {

    Window windowReference;

    public void addReference(Window windowReference) {
        this.windowReference = windowReference;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == windowReference.loadMapButton) {
            System.out.println("load");
        }
        else {
            if (source == windowReference.runAlgorithmsButton) {
                System.out.println("run");
            }
        }

    }
}
