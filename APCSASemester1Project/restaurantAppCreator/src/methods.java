import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class methods {

    private JSONArray ja = new JSONArray();
    private JSONArray swiftJA = new JSONArray();
    
    
    // Creates a JSONObject for a menu item - for Python
    public JSONObject createItem(String type, double price, String url, String description) {

        JSONObject object = new JSONObject();

        object.put("item_type", type);
        object.put("item_price", price);
        object.put("item_url", url);
        object.put("item_description", description);

        return object;
    }
    // Creates a JSONObject that is correctly formatted for Swift
    public JSONObject swiftJSONItem(int id, String name, String type, double price, String url, String description) {

        JSONObject object = new JSONObject();

        object.put("id", id);
        object.put("name", name);
        object.put("type", type);
        object.put("price", price);
        object.put("imageURL", url);
        object.put("description", description);
        
        return object;
        
    }
    // Adds the Python JSONObject to another object with the item name as a key and the object as the value
    public JSONObject finishItem(String name, JSONObject j) {
        JSONObject object = new JSONObject();

        object.put(name, j);

        return object;
    }
    // Adds JSONObject to JSONArray
    public void addItem(JSONObject j) {
        ja.add(j);
    }
    // Adds JSONObject to Swift JSONArray
    public void swiftAddItem(JSONObject j) {
        swiftJA.add(j);
    }
    // Simply returns the Swift JSONArray
    public JSONArray returnJA() {
        return swiftJA;
    }
    // Adds non-Swift JSONArray to JSONObject with the restaurant name as key and the JSONArray as the value
    public JSONObject mainJSON(String n) {
        JSONObject object = new JSONObject();

        object.put(n, ja);

        return object;
    }
    // Adds JSONObject to JSON file for Python
    public void addToFile(JSONObject jsonToAdd) {

        try {
            FileWriter file = new FileWriter("/Users/aviralmehrotra/Downloads/Code/Java/APCSASemester1Project/restaurantAppCreator/src/restaurantMenuAppTemplate/restaurantMenuAppTemplate/output.json");
            file.write(jsonToAdd.toJSONString());
            file.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    // Adds JSONObject to JSON file for Swift
    public void swiftAddToFile(JSONArray jArrayToAdd) {
        try {
            FileWriter file = new FileWriter("/Users/aviralmehrotra/Downloads/Code/Java/APCSASemester1Project/restaurantAppCreator/src/restaurantMenuAppTemplate/restaurantMenuAppTemplate/dataOutput.json");
            file.write(jArrayToAdd.toJSONString());
            file.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
