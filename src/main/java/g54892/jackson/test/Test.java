package g54892.jackson.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import g54892.humbug.model.Level;
import java.io.File;
import java.io.IOException;

/**
 * This class regroups tests to read data from a json file.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Test {

    /**
     * Constructor of Test.
     */
    public Test() {
    }

    public static void main(String[] args) throws IOException {

//var objectMapper = new ObjectMapper();
//var file = new File("src/main/ressources/data/test.json");
//var jsonNode = objectMapper.readTree(file);
//var inputStream = Test.class.getResourceAsStream("/data/test.json");
//var jsonNode = objectMapper.readTree(inputStream);
//System.out.println(jsonNode);
//System.out.println("Value: " + jsonNode.get("key").asText());

        /*var objectMapper = new ObjectMapper();
//var in = Test.class.getResourceAsStream("/data/position.json");
var file = new File("src/main/ressources/data/position.json");
Position position = objectMapper.readValue(file, Position.class);
System.out.println("Position read: " + position);*/
 /*var objectMapper = new ObjectMapper();
var in = Test.class.getResourceAsStream("/ressources/data/position.json");
Position position = objectMapper.readValue(in, Position.class);
System.out.println("Position read: " + position);*/
        var objectMapper = new ObjectMapper();
//var inputStream = Level.class.getResourceAsStream("data/level-1.json");
        var file = new File("src/main/ressources/data/level-1.json");
        var level = objectMapper.readValue(file, Level.class);
        System.out.println("level1" + level);

    }

}
