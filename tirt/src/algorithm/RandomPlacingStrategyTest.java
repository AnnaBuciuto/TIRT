package algorithm;

import main.MapController;
import map.MapLine;
import map.NetworkMap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RandomPlacingStrategyTest {


    @Test
    public void testCheckingIfRandomAccessPointsPlacementIsPlacingProperNumberOfAccessPoints() {
        String mapString = "xxxxxxxuuuooo\n"
                +"xxxxuuuuuuooo";
        int accessPointsNumber = 5;
        NetworkMap map = new NetworkMap(mapString);
        int emptySpacesNumber = map.getEmptySpaces().size();

        MapController controller = new MapController();
        controller.setMap(map);
        controller.setStrategy(new RandomPlacingStrategy());
        controller.placeAccessPoints(accessPointsNumber);
        assertEquals(emptySpacesNumber-map.getEmptySpaces().size(), accessPointsNumber);
    }


    @Test
    public void testPlaceAccessPointsMoreThanEmptySpaces() {
        String mapString = "xxxxxxxuuuooo\n"
                +"xxxxuuuuuuooo";
        int accessPointsNumber = 100;
        NetworkMap map = new NetworkMap(mapString);
        int emptySpacesNumber = map.getEmptySpaces().size();

        MapController controller = new MapController();
        controller.setMap(map);
        controller.setStrategy(new RandomPlacingStrategy());
        controller.placeAccessPoints(accessPointsNumber);
        assertEquals(map.getEmptySpaces().size(), emptySpacesNumber);
    }
}
