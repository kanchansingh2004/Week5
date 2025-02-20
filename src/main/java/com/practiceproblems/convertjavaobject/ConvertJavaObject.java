package com.practiceproblems.convertjavaobject;

import org.json.JSONObject;
//Create car class to store car details
class Car {
    private String name;
    private String model;
    private  String type;

    //Constructor to initialize values
    public Car(String name, String model, String type) {
        this.name = name;
        this.model = model;
        this.type = type;
    }

    //Getters to get the values of private variables
    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }
}
public class ConvertJavaObject {
    public static void main(String[] args) {
        //Car object to initialize car values
        Car car = new Car("Maruti", "800", "Petrol");

        //Object for JSON
        JSONObject object = new JSONObject();

        //Pass the car value
        object.put("Name", car.getName());
        object.put("Model", car.getModel());
        object.put("Type", car.getType());

        //Print the values
        System.out.println(object.toString(3));

    }
}
