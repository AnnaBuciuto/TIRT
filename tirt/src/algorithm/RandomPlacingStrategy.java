package algorithm;

import algorithm.exception.NotEnoughEmptySpacesException;
import map.NetworkMap;
import map.element.AccessPoint;
import map.element.MapElement;

import java.util.List;

public class RandomPlacingStrategy implements PlacingStrategy {

    @Override
    public NetworkMap placeAccessPoints(int numberOfAccessPoints, NetworkMap map) throws NotEnoughEmptySpacesException {
        List<MapElement> emptySpaces = map.getEmptySpaces();
        if (emptySpaces.size() < numberOfAccessPoints) {
            throw new NotEnoughEmptySpacesException();
        }
        for (int i = 0; i < numberOfAccessPoints; i++) {
            int randomNumber = randomNumber(emptySpaces.size());
            MapElement element = emptySpaces.remove(randomNumber);
            map.replace(element, new AccessPoint());
        }
        return map;
    }

    /**
     * Method that returns random number from range <0,upperRange)
     */
    public int randomNumber(int upperRange){
        return (int)Math.floor(Math.random()*(upperRange));
    }
}
