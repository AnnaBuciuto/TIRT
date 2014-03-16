package map;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class NetworkMapTest {

    @Test
    public void testConstructFromStringList() {
        String mapAsString =
                "xxxxx\n" +
                        "xxuxx\n" +
                        "xxxxu\n" +
                        "uxxxx\n";
        NetworkMap map = createMap(mapAsString);
        assertEquals(mapAsString, map.toString());
    }

    private NetworkMap createMap(String map) {
        String[] mapAsStringArray = StringUtils.splitString(map, "\n");
        List<String> mapAsStringList = Arrays.asList(mapAsStringArray);
        return new NetworkMap(mapAsStringList);
    }

    @Test
    public void testGetElement() {
        String mapAsString =
                "xxoxx\n" +
                        "xxuox";
        NetworkMap map = createMap(mapAsString);
        MapElement e = map.getElement(2, 1);
        assertThat(e, instanceOf(User.class));
    }

    @Test
    public void testSetElement() {
        String mapAsString =
                "uxoxx\n" +
                        "xxoox";
        NetworkMap map = createMap(mapAsString);
        map.setElement(0, 0, new User());
        MapElement e = map.getElement(0, 0);
        assertThat(e, instanceOf(User.class));
    }

}
