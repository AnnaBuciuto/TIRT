package algorithm;

import map.NetworkMap;
import map.element.AccessPoint;
import map.element.MapElement;

import java.util.ArrayList;
import java.util.List;

public class RandomPlacingStrategy implements PlacingStrategy {

    @Override
    public void placeAccessPoints(int numberOfAccessPoints, NetworkMap map) {
        List<MapElement> emptySpaces = map.getEmptySpaces();
        if (emptySpaces.size() < numberOfAccessPoints) {
            numberOfAccessPoints = emptySpaces.size();
        }
        for (int i = 0; i < numberOfAccessPoints; i++){
            int randomNumber = randomNumber(emptySpaces.size());
            MapElement element = emptySpaces.remove(randomNumber);
            map.replace(element, new AccessPoint());
        }
    }

    /**
     * Method that returns random number from radius <0,upperRange)
     */
    public int randomNumber(int upperRange){
        return (int)Math.floor(Math.random()*(upperRange));
    }
}
