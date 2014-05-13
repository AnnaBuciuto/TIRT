package map.element;

public class MapElementFactory {

    public static MapElement create(char c) {
        switch (c) {
            case Obstacle.MAP_KEY:
                return new Obstacle();
            case WindowObstacle.MAP_KEY:
                return new WindowObstacle();
            case Door.MAP_KEY:
                return new Door();
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

}
