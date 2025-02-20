package com.practiceproblems.mergejsonobjects;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class MergeJSONObjects {
    public static void main(String[] args) {
        // Creating first JSON object (student1)
        JSONObject student1 = new JSONObject();
        student1.put("email", "Kannursingh@gmail.com");
        student1.put("Name", "Kanchan");
        student1.put("age", 20);

        // Adding subjects as a JSON array
        List<String> subjects = Arrays.asList("Mathematics", "Computer Science", "Physics");
        student1.put("subject", new JSONArray(subjects));

        // Creating second JSON object (student2)
        JSONObject student2 = new JSONObject();
        student2.put("class", 12);
        student2.put("phone", 987654321);

        // Merging both JSON objects into a final JSON object
        JSONObject finalStudentJson = new JSONObject(student1, JSONObject.getNames(student1)); // Copy student1 data
        for (String key : JSONObject.getNames(student2)) {
            finalStudentJson.put(key, student2.get(key));
        }

        // Printing the merged JSON object
        System.out.println(finalStudentJson.toString(4));
    }
}
