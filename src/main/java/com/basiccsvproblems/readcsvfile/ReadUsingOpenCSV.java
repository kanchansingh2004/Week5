package com.basiccsvproblems.readcsvfile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class ReadUsingOpenCSV {
    public static void main(String[] args) {
        //Store the file path
        String filePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\basiccsvproblems\\readcsvfile\\read.csv";
        //Using Try and catch block to handle exception(If any)
        try(CSVReader reader = new CSVReader(new FileReader(filePath))){
            String[] line;
            //Run a whie loop to print the file data using string array
            while((line = reader.readNext())!=null){
                System.out.println(line[0] + ", " + line[1] + ", " + line[2] + ", " + line[3]);
            }
        }catch (IOException | CsvValidationException e){
            //Print message
            e.printStackTrace();
        }
    }
}
