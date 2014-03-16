package map;


public class MapElement {

    public static MapElement create(char c) {
        switch (c) {
            case Obstacle.MAP_KEY:
                return new Obstacle();
            case User.MAP_KEY:
                return new User();
            case EmptySpace.MAP_KEY:
                return new EmptySpace();
            default:
                throw new IllegalArgumentException(
                        String.format("No element with code %s exists.", c)
                );
        }
    }

    public char getMapKey() {
        return 0;
    }

}
