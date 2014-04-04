package map;


import com.sun.deploy.util.StringUtils;
import map.element.MapElement;
import map.element.EmptySpace;

import java.util.ArrayList;
import java.util.Arrays;
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

    public NetworkMap(String map) {
        this(Arrays.asList(StringUtils.splitString(map, "\n")));
    }


    public void setElement(int column, int row, MapElement element) {
        map.get(row).set(column, element);
    }

    public MapElement getElement(int column, int row) {
        return map.get(row).get(column);
    }

    public int[] getIndex(MapElement element){
        for (int row = 0; row < map.size(); row++){
            for (int column = 0; column < map.get(0).line.size(); column++){
                if (element == this.getElement(column, row)){
                    return new int[]{column, row};
                }
            }
        }
        return null;
    }

    public List<MapElement> getEmptySpaces(){
        List<MapElement> emptySpaces = new ArrayList<MapElement>();
        for (MapLine mapLineElement : map){
            for (MapElement element : mapLineElement.line) {
                if (element.getMapKey() == EmptySpace.MAP_KEY){
                    emptySpaces.add(element);
                }
            }
        }
        return emptySpaces;
    }

    public void replace(MapElement current, MapElement desired){
        int[] indexes = this.getIndex(current);
        this.setElement(indexes[0], indexes[1], desired);
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
