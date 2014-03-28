package algorithm;

import map.NetworkMap;
import map.element.AccessPoint;
import map.element.MapElement;

import java.util.ArrayList;
import java.util.List;

public class RandomPlacingStrategy implements PlacingStrategy {

    @Override
    public void placeAccessPoints(int n, NetworkMap map) {
        List<MapElement> emptySpaces = map.getEmptySpaces();
        if (emptySpaces.size()<n)
            n = emptySpaces.size();

        for (int i=0; i<n; i++){
            int number = (int)Math.floor(Math.random()*emptySpaces.size());
            MapElement element = emptySpaces.remove(number);
            map.replace(element,new AccessPoint());
        }
    }
}
