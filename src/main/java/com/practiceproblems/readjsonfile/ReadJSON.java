package com.practiceproblems.readjsonfile;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ReadJSON {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file into a JsonNode object
            JsonNode rootNode = objectMapper.readTree(new File("src/main/java/com/practiceproblems/readjsonfile/read.json"));

            // Loop through each object in the array
            if(rootNode.isArray()){
                for (JsonNode node : rootNode) {
                    String name = node.get("name").asText();
                    String email = node.get("email").asText();
                    System.out.println("Name: " + name + ", Email: " + email);
                }
            }

        } catch (Exception e) {
            //Print the valid the message
            System.out.println("Error: " + e.getMessage());
        }
    }
}
