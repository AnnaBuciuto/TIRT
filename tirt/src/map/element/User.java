package map.element;


public class User implements MapElement {

    public static final char MAP_KEY = 'u';

    @Override
    public char getMapKey() {
        return MAP_KEY;
    }

}
