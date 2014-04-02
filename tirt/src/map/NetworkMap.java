package map;


import com.sun.deploy.util.StringUtils;
import map.element.MapElement;
import map.element.User;

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

    /**
     *
     * @param y - row of map
     * @param x - column of map
     * @param element - element to set at specified row and column
     */
    public void setElement(int y, int x, MapElement element) {
        map.get(y).set(x,element);
    }

    public MapElement getElement(int y, int x) {
        return map.get(y).get(x);
    }

    public int[] getIndex(MapElement e){
        for (int y=0; y<map.size(); y++){
            for (int x=0; x<map.get(0).line.size();x++){
                if (e == this.getElement(y,x)){
                    return new int[]{y,x};
                }
            }
        }
        return null;
    }


    public List<MapElement> getEmptySpaces(){
        List<MapElement> emptySpaces = new ArrayList<MapElement>();
        for (MapLine mapLineElement : map){
            for (MapElement element : mapLineElement.line) {
                if (element.getMapKey() == 'x'){
                    emptySpaces.add(element);
                }
            }
        }
        return emptySpaces;
    }

    public void replace(MapElement current, MapElement desired){
        int[] index = this.getIndex(current);
        this.setElement(index[0], index[1], desired);
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
