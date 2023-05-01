/*package edu.quelis.projet;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Finder {

    public static void main(String[] args) {
        ArrayList<String> shovelItems = getShovelItems("items.json");
        System.out.println(shovelItems);
    }

    public static ArrayList<String> getShovelItems(String fileName) {
        ArrayList<String> shovelItems = new ArrayList<String>();
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(fileName));
            JSONArray itemList = (JSONArray) obj;
            for (Object item : itemList) {
                JSONObject itemObject = (JSONObject) item;
                if (itemObject.get("displayName").toString().contains("Shovel")) {
                    shovelItems.add(itemObject.get("displayName").toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shovelItems;
    }
}*/