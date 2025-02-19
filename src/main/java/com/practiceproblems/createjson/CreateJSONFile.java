package com.practiceproblems.createjson;
import org.json.JSONArray;
import org.json.JSONObject;
public class CreateJSONFile {
    public static void main(String[] args) {
        //Create JSON array object to store array element
        JSONArray subject = new JSONArray();
        subject.put("Maths");
        subject.put("Science");
        subject.put("Chemistry");

        //Create JSON object to store and display data
        JSONObject object = new JSONObject();
        object.put("name","Kuchu");
        object.put("age",20);
        object.put("subject",subject); //pass the array
        System.out.println(object.toString());
    }
}
