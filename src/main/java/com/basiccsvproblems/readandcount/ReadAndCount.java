package com.basiccsvproblems.readandcount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCount {
    public static void main(String[] args) {
        //Store the file path
        String path = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\basiccsvproblems\\readandcount\\count.csv";
        //Store the result and display
        int count = countTheRecords(path);
        if(count == -1){
            System.out.println("No record found!!");
        }
        else{
            System.out.println("Record read successfully\nThe number of records are: " + count);
        }
    }

    public static int countTheRecords(String path) {
        //Variable to count the record
        int count = -1;
        //try and catch block to handle the exception
        try{
            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while(line != null){
                count++; //count the record
                line = bufferedReader.readLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        //return the count
        return count;
    }
}
