package input;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class MapReaderTest {

    @Test
    public void testReadFile() {
        String fileName = "tirt/maps/map1.txt";
        MapReader reader = new MapReader();
        List<String> map = reader.readFile(fileName);
        assertEquals(StringUtils.join(map, "\n"),
                "xxxxxx\n" +
                        "xxxxxx\n" +
                        "xxxxux\n" +
                        "xxxxux\n" +
                        "uxxxxu"
        );
    }

}
