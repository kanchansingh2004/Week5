package com.advancecsvproblems.mergecsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {

    public static void main(String[] args) {
        String file1Path = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\advancecsvproblems\\mergecsv\\student1.csv";
        String file2Path = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\advancecsvproblems\\mergecsv\\student2.csv";
        String outputPath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\advancecsvproblems\\mergecsv\\mergedFile.csv";

        boolean result = mergeCsvFiles(file1Path, file2Path, outputPath);
        if (result) {
            System.out.println("CSV files merged successfully! Output file: " + outputPath);
        } else {
            System.out.println("Failed to merge CSV files.");
        }
    }

    public static boolean mergeCsvFiles(String file1Path, String file2Path, String outputPath) {
        try (CSVReader reader1 = new CSVReader(new FileReader(file1Path));
             CSVReader reader2 = new CSVReader(new FileReader(file2Path));
             CSVWriter writer = new CSVWriter(new FileWriter(outputPath))) {

            // Read header rows
            String[] header1 = reader1.readNext(); // Header of file1
            String[] header2 = reader2.readNext(); // Header of file2

            // Create combined header for the merged file
            String[] mergedHeader = new String[]{header1[0], header1[1], header1[2], header2[1], header2[2]};
            writer.writeNext(mergedHeader);

            // Store records from file2 in a map for quick lookup by ID
            Map<String, String[]> file2Data = new HashMap<>();
            String[] line2;
            while ((line2 = reader2.readNext()) != null) {
                file2Data.put(line2[0], line2);
            }

            // Process file1 and merge data with file2
            String[] line1;
            while ((line1 = reader1.readNext()) != null) {
                String id = line1[0];
                String[] file2Row = file2Data.get(id); // Lookup matching row in file2
                if (file2Row != null) {
                    String[] mergedRow = new String[]{
                            line1[0], // ID
                            line1[1], // Name
                            line1[2], // Age
                            file2Row[1], // Marks
                            file2Row[2]  // Grade
                    };
                    writer.writeNext(mergedRow); // Write merged row to output
                }
            }
            return true;

        } catch (IOException | CsvValidationException e) {
            System.out.println("Error processing CSV files: " + e.getMessage());
            return false;
        }
    }
}

