package com.intermediatecsvproblems.modifyfile;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModifyCsvFile {
    public static void main(String[] args) {
        String inputFilePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\intermediatecsvproblems\\modifyfile\\modify.csv";
        String outputFilePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\intermediatecsvproblems\\modifyfile\\modified.csv";

        if (modify(inputFilePath, outputFilePath)) {
            System.out.println("CSV file modified and saved successfully!");
        } else {
            System.out.println("Failed to modify the CSV file.");
        }
    }

    public static boolean modify(String inputFilePath, String outputFilePath) {
        boolean isModified = false;
        //try and catch block to handle the exceptions
        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {

            String[] line;
            boolean isHeader = true;

            while ((line = reader.readNext()) != null) {
                // Write the header as-is
                if (isHeader) {
                    writer.writeNext(line);
                    isHeader = false;
                    continue;
                }

                // Check if the department is "IT" and update the salary
                if (line[2].trim().equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(line[3]);
                    salary += salary * 0.10;
                    // Update the salary in the array
                    line[3] = String.valueOf(salary);
                }
                writer.writeNext(line);
            }

            isModified = true; // Modification completed successfully
        } catch (IOException | NumberFormatException | CsvValidationException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
        return isModified;
    }
}

