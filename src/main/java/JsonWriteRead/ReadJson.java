package JsonWriteRead;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("dat\\users.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray personList = (JSONArray) obj;
            personList.forEach( emp -> JsonFileReaderWriter( (JSONObject) emp ) );
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    private static void JsonFileReaderWriter(JSONObject person) {
        JSONObject personObject = (JSONObject) person.get("person");
        String name = (String) personObject.get("name");
        System.out.println("name: " + name);
        String age = (String) personObject.get("age");
        System.out.println("age: " + age);
        String email = (String) personObject.get("email");
        System.out.println("email: " + email);
        System.out.println(" ");
    }
}