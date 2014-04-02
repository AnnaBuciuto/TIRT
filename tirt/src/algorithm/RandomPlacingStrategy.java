package algorithm;

import map.NetworkMap;
import map.element.AccessPoint;
import map.element.MapElement;

import java.util.ArrayList;
import java.util.List;

public class RandomPlacingStrategy implements PlacingStrategy {

    @Override
    public void placeAccessPoints(int number, NetworkMap map) {
        List<MapElement> emptySpaces = map.getEmptySpaces();
        if (emptySpaces.size() < number) {
            number = emptySpaces.size();
        }
        for (int i = 0; i < number; i++){
            int randomNumber = (int)Math.floor(Math.random()*emptySpaces.size());
            MapElement element = emptySpaces.remove(randomNumber);
            map.replace(element, new AccessPoint());
        }
    }
}
