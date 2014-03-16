package input;

import map.NetworkMap;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MapReader {

    public NetworkMap readMapFromFile(String fileName) {
        List<String> lines = readFile(fileName);
        return new NetworkMap(lines);
    }

    /*package*/ List<String> readFile(String fileName) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
