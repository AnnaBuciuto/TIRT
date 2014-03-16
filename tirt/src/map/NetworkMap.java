package map;


import java.util.ArrayList;
import java.util.List;

public class NetworkMap {

    List<MapLine> map;

    public NetworkMap(List<String> input) {
        map = new ArrayList<>(input.size());
        for (String inputLine : input) {
            MapLine line = new MapLine(inputLine);
            map.add(line);
        }
    }

    public void setElement(int x, int y, MapElement element) {
        // TODO
    }

    public MapElement getElement(int x, int y) {
        // TODO
        return new User();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (MapLine line : map) {
            sb.append(String.format("%s\n", line));
        }
        return sb.toString();
    }

}
