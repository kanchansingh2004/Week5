package com.handsonpracticeproblems.readjson;

import java.nio.file.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadJSONFile {
    public static void main(String[] args) throws Exception {
        String filePath = "src/main/java/com/handsonpracticeproblems/readjson/read.json";
        // Create a Path object from the file path
        Path path = Paths.get(filePath);
        // Read all bytes from the file into a byte array
        byte[] fileBytes = Files.readAllBytes(path);
        // Convert the byte array into a String
        String content = new String(fileBytes);
        // Create a JSONArray from the String content
        JSONArray jsonArray = new JSONArray(content);
        // Iterate over the JSONArray and print each JSONObject's key-value pairs
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println("Object " + (i + 1) + ":");
            for (String key : jsonObject.keySet()) {
                System.out.println(key + ": " + jsonObject.get(key));
            }
            System.out.println();
        }
    }
}
