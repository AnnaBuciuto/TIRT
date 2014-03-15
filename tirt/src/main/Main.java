package main;

import input.MapReader;


public class Main {

    public static void main(String[] args) {
        String fileName = "tirt/maps/map1.txt";
        MapReader reader = new MapReader();
        reader.readMap(fileName);
    }

}
