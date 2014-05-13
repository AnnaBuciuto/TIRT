package main;

import algorithm.RandomPlacingStrategy;
import gui.Window;
import input.MapReader;
import map.NetworkMap;
import map.NetworkSignalCalculator;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EventHandler implements ActionListener {

    Window windowReference;
    MapController mapControllerReference;

    public void addReferences(Window windowReference, MapController mapControllerReference) {
        this.windowReference = windowReference;
        this.mapControllerReference = mapControllerReference;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == windowReference.loadMapButton) {
            final JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt", "text");
            fc.setFileFilter(filter);
            int returnVal = fc.showOpenDialog(windowReference);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                MapReader mapReader = new MapReader();
                NetworkMap map = mapReader.readMapFromFile(fc.getSelectedFile().getAbsolutePath());
                mapControllerReference.setMap(map);
                windowReference.mapPanel1.paintMap(map);
            }
        }
        else {
            if (source == windowReference.runAlgorithmsButton) {
                //to delete
                RandomPlacingStrategy strategy = new RandomPlacingStrategy();
                mapControllerReference.setStrategy(strategy);
                NetworkMap randomizedMap = mapControllerReference.placeAccessPoints(2);
                windowReference.mapPanel1.paintMap(randomizedMap);
                NetworkSignalCalculator calc = randomizedMap.getNetworkSignalCalculator();
                System.out.println(calc.bestSignalPowerAtPoint(1,1));
            }
        }
    }
}
