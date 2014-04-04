package algorithm;

import algorithm.exception.NotEnoughEmptySpacesException;
import map.NetworkMap;

public interface PlacingStrategy {

    public void placeAccessPoints(int numberOfAccessPoints, NetworkMap map) throws NotEnoughEmptySpacesException;

}
