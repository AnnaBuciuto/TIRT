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


    /*
    y - wiersz
    x - kolumna
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
                if (e == this.getElement(y,x))
                    return new int[]{y,x};
            }
        }
        return null;
    }
    public List<MapLine> getMap(){
        return map;
    }
    public MapElement[][] getArray(){
        if (map.size()>0 && map.get(0).line.size()>0){
            MapElement[][] array = new MapElement[map.size()][map.get(0).line.size()];
            int y = 0;
            for (MapLine line : map){
                int x = 0;
                for (MapElement element : line.line){
                    array[y][x] = element;
                    x++;
                }
                y++;
            }
            return array;
        }else
            return null;
    }
    public List<MapElement> getEmptySpaces(){
        MapElement[][] array = this.getArray();
        List<MapElement> emptySpaces = new ArrayList<MapElement>();
        for (int y=0; y<array.length; y++){
            for (int x=0; x<array[y].length; x++){
                if (array[y][x].getMapKey() == 'x')
                    emptySpaces.add(array[y][x]);
            }
        }
        return emptySpaces;
    }
    public void replace(MapElement current, MapElement desired){
        int[] index = this.getIndex(current);
        this.setElement(index[0],index[1],desired);
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
