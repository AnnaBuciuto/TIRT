package map;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class NetworkSignalCalculatorTest {

    @Test
    public void testDistanceBetween(){
        NetworkSignalCalculator calc = new NetworkSignalCalculator(null);

        assertEquals(calc.distanceBetween(1,1,2,1),1,0);
        assertEquals(calc.distanceBetween(1,1,7,1),6,0);
        assertEquals(calc.distanceBetween(10,10,10,1),9,0);
    }

    @Test
    public void testObstaclesBetween(){
        String mapAsString =
                "oxxxxxx\n" +
                "oxxwxxx\n" +
                "oxxwxxx\n" +
                "oxxxxxx\n";
        NetworkMap map = new NetworkMap(mapAsString);
        NetworkSignalCalculator calc = map.getNetworkSignalCalculator();

        assertEquals(calc.obstaclesBetween(0,0,0,3)[0],2);
        assertEquals(calc.obstaclesBetween(0,3,0,0)[0],2);
        assertEquals(calc.obstaclesBetween(0,2,0,0)[0],1);
        assertEquals(calc.obstaclesBetween(0,0,0,0)[0],0);
        assertEquals(calc.obstaclesBetween(0,0,0,1)[0],0);

        assertEquals(calc.obstaclesBetween(6,1,5,3)[2],0);
        assertEquals(calc.obstaclesBetween(2,0,4,3)[2],2);
    }

    @Test
    public void testSignalPowerBetween(){
        String mapAsString =
                "xxwxoxx\n" +
                "xxwxoxx\n" +
                "xxwxoxx\n" +
                "xxwxoxx\n";
        NetworkMap map = new NetworkMap(mapAsString);
        NetworkSignalCalculator calc = map.getNetworkSignalCalculator();

        assertTrue(calc.signalPowerBetween(0,0,6,3) < calc.signalPowerBetween(0,0,4,0));
    }
}
