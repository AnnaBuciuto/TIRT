package main;

import algorithm.RandomPlacingStrategy;
import input.MapReader;
import map.NetworkMap;


public class Main {

    public static void main(String[] args) {
        String fileName = "tirt/maps/map2.txt";
        MapReader reader = new MapReader();
        NetworkMap map = reader.readMapFromFile(fileName);

        MapController controller = new MapController();
        controller.setMap(map);
        controller.setStrategy(new RandomPlacingStrategy());
        controller.placeAccessPoints();

        System.out.println(map);
    }

}
