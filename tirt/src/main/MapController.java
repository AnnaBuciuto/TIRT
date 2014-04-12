package main;

import algorithm.PlacingStrategy;
import algorithm.exception.NotEnoughEmptySpacesException;
import map.NetworkMap;

public class MapController {

    private PlacingStrategy strategy;
    public NetworkMap map;
    public NetworkMap resultMap;

    public void setMap(NetworkMap map) {
        this.map = map;
    }

    public void setStrategy(PlacingStrategy strategy) {
        this.strategy = strategy;
    }

    public NetworkMap placeAccessPoints(int n) {
        try {
            resultMap = strategy.placeAccessPoints(n, map.clone());
        }catch(NotEnoughEmptySpacesException e) {
            //TODO Inform user that there that there is less empty spaces than access points desired
            System.out.println("There is less empty spaces than access points to be placed.");
        }
        return resultMap;
    }

}
