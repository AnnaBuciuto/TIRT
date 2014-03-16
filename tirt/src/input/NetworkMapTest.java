package input;

import com.sun.deploy.util.StringUtils;
import map.NetworkMap;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NetworkMapTest {

    @Test
    public void testConstructFromStringList() {
        String mapAsString =
                "xxxxx\n" +
                        "xxuxx\n" +
                        "xxxxu\n" +
                        "uxxxx\n";

        String[] mapAsStringArray = StringUtils.splitString(mapAsString, "\n");
        List<String> mapAsStringList = Arrays.asList(mapAsStringArray);

        NetworkMap map = new NetworkMap(mapAsStringList);
        assertEquals(mapAsString, map.toString());
    }
}
