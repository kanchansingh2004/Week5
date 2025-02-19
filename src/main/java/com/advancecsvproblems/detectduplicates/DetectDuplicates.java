package com.advancecsvproblems.detectduplicates;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DetectDuplicates {

    public static void main(String[] args) {
        //Store file path
        String filePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\advancecsvproblems\\detectduplicates\\students.csv";
        detectDuplicates(filePath);
    }

    public static void detectDuplicates(String filePath) {
        Map<String, Integer> idCountMap = new HashMap<>(); // Store counts for IDs

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext(); // Skip header row
            String[] line;

            // Count occurrences of each ID
            while ((line = reader.readNext()) != null) {
                String id = line[0];
                idCountMap.put(id, idCountMap.getOrDefault(id, 0) + 1);
            }

            // Print duplicate records
            System.out.println("Duplicate records based on ID:");
            idCountMap.forEach((id, count) -> {
                if (count > 1) {
                    System.out.println("ID: " + id + " appears " + count + " times.");
                }
            });

        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}

