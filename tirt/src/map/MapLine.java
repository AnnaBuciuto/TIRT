package map;

import map.element.MapElement;
import map.element.MapElementFactory;

import java.util.ArrayList;
import java.util.List;

public class MapLine {

    List<MapElement> line;

    public MapLine(String input) {
        line = new ArrayList<>(input.length());
        for (char c : input.toCharArray()) {
            line.add(MapElementFactory.create(c));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (MapElement e : line) {
            sb.append(e.getMapKey());
        }
        return sb.toString();
    }

}
