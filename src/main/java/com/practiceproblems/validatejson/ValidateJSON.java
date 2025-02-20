package com.practiceproblems.validatejson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJSON {
    public static void main(String[] args) {
        // Sample JSON string
        String jsonString = "{"
                + "\"name\": \"Kanchan\","
                + "\"age\": 22,"
                + "\"subjects\": [\"Mathematics\", \"Computer Science\", \"Physics\"]"
                + "}";

        // Validate JSON structure
        if (isValidJson(jsonString)) {
            System.out.println("Valid JSON!");
        } else {
            System.out.println("Invalid JSON!");
        }
    }

    // Method to validate JSON
    public static boolean isValidJson(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Parse JSON
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            // If parsing is successful, JSON is valid
            return jsonNode != null;
        } catch (Exception e) {
            // JSON is invalid if an exception occurs
            return false;
        }
    }
}

