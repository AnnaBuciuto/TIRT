package map;

import map.element.MapElement;
import map.element.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class NetworkMapTest {

    @Test
    public void testConstructFromString() {
        String mapAsString =
                "xxxxx\n" +
                        "xxuxx\n" +
                        "xxxxu\n" +
                        "uxxxx\n";
        NetworkMap map = new NetworkMap(mapAsString);
        assertEquals(mapAsString, map.toString());
    }

    @Test
    public void testGetElement() {
        String mapAsString =
                "xxoxx\n" +
                        "xxuox";
        NetworkMap map = new NetworkMap(mapAsString);
        MapElement e = map.getElement(2, 1);
        assertThat(e, instanceOf(User.class));
    }

    @Test
    public void testSetElement() {
        String mapAsString =
                "uxoxx\n" +
                        "xxoox";
        NetworkMap map = new NetworkMap(mapAsString);
        map.setElement(2, 1, new User());
        MapElement e = map.getElement(2, 1);
        assertThat(e, instanceOf(User.class));
    }

}
