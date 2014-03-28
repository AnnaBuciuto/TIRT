package main;

import algorithm.PlacingStrategy;
import map.NetworkMap;

public class MapController {

    private PlacingStrategy strategy;
    private NetworkMap map;

    public void setMap(NetworkMap map) {
        this.map = map;
    }

    public void setStrategy(PlacingStrategy strategy) {
        this.strategy = strategy;
    }

    public void placeAccessPoints(int n) {
        strategy.placeAccessPoints(n,map);
    }

}
