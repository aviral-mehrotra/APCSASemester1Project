import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class run {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        methods menu = new methods();

        System.out.println("Enter Restaurant Name:");
        String restaurantName = input.nextLine();

        System.out.println("Do you want to add items to a menu? (Yes / No):");
        String decision = input.nextLine();
        decision = decision.toLowerCase();

        if (decision.equals("no")) {
            System.out.println("Okay, have a great day!");
            System.exit(0);
        }

        System.out.println("Great, how many items do you want to enter?");
        int numberOfItems = input.nextInt();
        input.nextLine();

        System.out.println("To create a menu item, add a name, type, price, image (url), and description");

        int counter = 0;

        for (int i = 1; i <= numberOfItems; i++) {
            
            System.out.println("Item " + i + " Name: ");
            String itemName = input.nextLine();

            System.out.println("Item " + i + " Type: ");
            String itemType = input.nextLine();

            System.out.println("Item " + i + " Price ($): ");
            double itemPrice = input.nextDouble();
            input.nextLine();

            System.out.println("Item " + i + " Image URL: ");
            String imageURL = input.nextLine();

            System.out.println("Item " + i + " Description: ");
            String itemDescription = input.nextLine();

            System.out.println();

            counter = i;

            JSONObject item = menu.createItem(itemType, itemPrice, imageURL, itemDescription);
            JSONObject finishedItem = menu.finishItem(itemName, item);
            menu.addItem(finishedItem);

            JSONObject swiftItem = menu.swiftJSONItem(counter, itemName, itemType, itemPrice, imageURL, itemDescription);
            menu.swiftAddItem(swiftItem);

        }
        
        System.out.println("Add more items? (Yes / No):");
        String addMore = (input.nextLine()).toLowerCase();

        while (addMore.equals("yes")) {
            System.out.println("Item Name: ");
            String itemName = input.nextLine();

            System.out.println("Item Type: ");
            String itemType = input.nextLine();

            System.out.println("Item Price ($): ");
            double itemPrice = input.nextDouble();
            input.nextLine();
            
            System.out.println("Item Image URL: ");
            String imageURL = input.nextLine();

            System.out.println("Item Description: ");
            String itemDescription = input.nextLine();

            System.out.println("Add more items? (Yes / No):");
            addMore = (input.nextLine()).toLowerCase();

            System.out.println();

            JSONObject item = menu.createItem(itemType, itemPrice, imageURL, itemDescription);
            JSONObject finishedItem = menu.finishItem(itemName, item);
            menu.addItem(finishedItem);

            counter++;

            JSONObject swiftItem = menu.swiftJSONItem(counter, itemName, itemType, itemPrice, imageURL, itemDescription);
            menu.swiftAddItem(swiftItem);
        }

        input.close();

        JSONObject jsonData = menu.mainJSON(restaurantName);
        menu.addToFile(jsonData);

        JSONArray swiftJAToAdd = menu.returnJA();
        menu.swiftAddToFile(swiftJAToAdd);

        String command = "python3 /Users/aviralmehrotra/Downloads/Code/Java/APCSASemester1Project/restaurantAppCreator/src/imageDownloader.py";
        Process p = Runtime.getRuntime().exec(command);

    }
}
