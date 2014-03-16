package input;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class MapReaderTest {

    @Test
    public void testReadMapFromFile() {
        String fileName = "tirt/maps/map1.txt";
        MapReader reader = new MapReader();
        List<String> map = reader.readMap(fileName);
        assertEquals(StringUtils.join(map, "\n"),
                "xxxxxx\n" +
                        "xxxxxx\n" +
                        "xxxxux\n" +
                        "xxxxux\n" +
                        "uxxxxu"
        );
    }

}
