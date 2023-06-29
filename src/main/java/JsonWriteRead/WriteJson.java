package JsonWriteRead;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJson {
    @SuppressWarnings("unchecked")
    public static void main( String[] args ) {
        JSONObject personDetails = new JSONObject();
        personDetails.put("name", "John Doe");
        personDetails.put("age", "30");
        personDetails.put("email", "johndoe@example.com");
        JSONObject personObject = new JSONObject();
        personObject.put("person", personDetails);

        JSONObject personDetails2 = new JSONObject();
        personDetails2.put("name", "Alice");
        personDetails2.put("age", "32");
        personDetails2.put("email", "bob@example.com");
        JSONObject personObject2 = new JSONObject();
        personObject2.put("person", personDetails2);

        JSONArray personList = new JSONArray();
        personList.add(personObject);
        personList.add(personObject2);

        try (FileWriter file = new FileWriter("dat\\users.json")) {
            file.write(personList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}