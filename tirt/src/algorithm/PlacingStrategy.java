package algorithm;

import algorithm.exception.NotEnoughEmptySpacesException;
import map.NetworkMap;

public interface PlacingStrategy {

    public NetworkMap placeAccessPoints(int numberOfAccessPoints, NetworkMap map) throws NotEnoughEmptySpacesException;

}
