package main;

import gui.Window;


public class Main {

    public static void main(String[] args) {
//        String fileName = "tirt/maps/map2.txt";
//        MapReader reader = new MapReader();
//        NetworkMap map = reader.readMapFromFile(fileName);
//
        MapController controller = new MapController();
//        controller.setMap(map);
//        controller.setStrategy(new RandomPlacingStrategy());
//        controller.placeAccessPoints(5);
//        System.out.println(map);

        EventHandler eventHandler = new EventHandler();
        Window mainWindow = new Window("", eventHandler);
        eventHandler.addReference(mainWindow);

        mainWindow.setVisible(true);



    }

}
