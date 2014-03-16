package map;

public class EmptySpace implements MapElement {

    public static final char MAP_KEY = 'x';

    @Override
    public char getMapKey() {
        return MAP_KEY;
    }

}
