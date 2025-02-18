package com.intermediatecsvproblems.sortcsv;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class SortCSV {
    public static void main(String[] args) {
        String inputFilePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\intermediatecsvproblems\\sortcsv\\unsorted.csv";
        ArrayList<String[]> records = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath))) {
            String[] employee;

            // Read and add all records to the ArrayList
            while ((employee = reader.readNext()) != null) {
                records.add(employee);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Remove the header and store it separately
        String[] header = records.removeFirst();

        // Sort records by salary in descending order
        records.sort((emp1, emp2) -> Integer.parseInt(emp2[3]) - Integer.parseInt(emp1[3]));

        // Print the header
        System.out.println(String.join(", ", header));

        // Print the top 5 highest-paid employees
        for (int i = 0; i < 5 && i < records.size(); i++) {
            System.out.println(String.join(", ", records.get(i)));
        }
    }
}
