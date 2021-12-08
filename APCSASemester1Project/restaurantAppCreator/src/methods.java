import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


// Reformat the JSON so the name of each item is a key with the other inputs as values


public class methods {

    private JSONArray ja = new JSONArray();
    private JSONArray swiftJA = new JSONArray();

    public JSONObject createItem(String type, double price, String url, String description) {

        JSONObject object = new JSONObject();

        object.put("item_type", type);
        object.put("item_price", price);
        object.put("item_url", url);
        object.put("item_description", description);

        return object;
    }

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

    public JSONObject finishItem(String name, JSONObject j) {
        JSONObject object = new JSONObject();

        object.put(name, j);

        return object;
    }

    public void addItem(JSONObject j) {
        ja.add(j);
    }

    public void swiftAddItem(JSONObject j) {
        swiftJA.add(j);
    }

    public JSONArray returnJA() {
        return swiftJA;
    }

    public JSONObject mainJSON(String n) {
        JSONObject object = new JSONObject();

        object.put(n, ja);

        return object;
    }

    public void addToFile(JSONObject jsonToAdd) {

        try {
            FileWriter file = new FileWriter("/Users/aviralmehrotra/Downloads/Code/Java/APCSASemester1Project/restaurantAppCreator/src/restaurantMenuAppTemplate/restaurantMenuAppTemplate/output.json");
            file.write(jsonToAdd.toJSONString());
            file.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

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
