package main;

import algorithm.PlacingStrategy;
import algorithm.exception.NotEnoughEmptySpacesException;
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

    public void placeAccessPoints(int n)  {
        try {
            strategy.placeAccessPoints(n, map);
        }catch(NotEnoughEmptySpacesException e){
            //TODO Inform user that there that there is less empty spaces than access points desired
            System.out.println("There is less empty spaces than access points to be placed.");
        }
    }

}
