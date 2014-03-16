package map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapLineTest {

    @Test
    public void testConstructFromString() {
        String line = "xxxuo";
        MapLine mapLine = new MapLine(line);
        assertEquals(mapLine.toString(), line);
    }

}
