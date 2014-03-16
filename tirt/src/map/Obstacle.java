package map;

public class Obstacle implements MapElement {

    public static final char MAP_KEY = 'o';

    @Override
    public char getMapKey() {
        return MAP_KEY;
    }

}
