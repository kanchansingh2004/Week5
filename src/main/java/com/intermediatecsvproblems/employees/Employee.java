package com.intermediatecsvproblems.employees;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class Employee {
    public static void main(String[] args) {
        //Store the file path and employee to be searched
        String path = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\intermediatecsvproblems\\employees\\employees.csv";
        String employeeName = "Jungkook";

        //Method call to search employee using name
        if(searchEmployee(path, employeeName)){
            System.out.println("Successfully found employee with name: " + employeeName);
        }else{
            System.out.println("No such Employee exist");
        }
    }

    //Method to search an employee by name and display the department and salary
    public static boolean searchEmployee(String path, String employeeName) {
        boolean result = false;
        //Using Try and catch block to handle exception(If any)
        try(CSVReader reader = new CSVReader(new FileReader(path))){
            String[] line = reader.readNext();
            while((line = reader.readNext())!=null){
                //Match the employee name amd display the details
                if(employeeName.equals((line[1].trim()))){
                    result = true;
                    System.out.println("Department: " + line[2] + "\n" + "Salary: " + line[3]);
                }
            }
        }catch (IOException e){
            //Print valid message
            System.out.println(e.getMessage());

        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
