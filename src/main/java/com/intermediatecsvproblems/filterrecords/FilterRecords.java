package com.intermediatecsvproblems.filterrecords;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
        //Store the file path
        String path = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\intermediatecsvproblems\\filterrecords\\studentRecord.csv";
        //Method call to filter students
        filteredStudents(path);
    }
    public static int filteredStudents(String path) {
        int count = 0;
        //Using Try and catch block to handle exception(If any)
        try (FileReader fileReader = new FileReader(path);
             CSVReader reader = new CSVReader(fileReader)) {

            // Skip the header row
            String[] line = reader.readNext();
            System.out.println("Students having marks greater than 80 are:");

            while ((line = reader.readNext()) != null) {
                try {
                    // Validate and parse the marks column
                    if (line[2] != null && !line[2].isEmpty()) {
                        int marks = Integer.parseInt(line[2].trim());
                        if (marks > 80) {
                            System.out.println(line[1]);
                            count++;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid marks value in row: " + String.join(", ", line));
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println(e.getMessage());
        }

        //Return count of total students
        return count;
    }
}
