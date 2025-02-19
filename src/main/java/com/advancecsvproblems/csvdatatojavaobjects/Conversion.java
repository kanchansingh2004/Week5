package com.advancecsvproblems.csvdatatojavaobjects;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Conversion {
    public static void main(String[] args) {
        String filePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\advancecsvproblems\\csvdatatojavaobjects\\students.csv";

        // Convert CSV rows to Student objects
        List<Student> students = convertCsvToObjects(filePath);

        // Print the list of students
        if (students != null) {
            System.out.println("Student Details:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Method to read CSV and convert rows into Student objects
    public static List<Student> convertCsvToObjects(String filePath) {
        List<Student> students = new ArrayList<>();

        //try and catch block to handle exception
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext(); // Read and skip the header row
            if (header == null) {
                System.out.println("CSV file is empty!");
                return null;
            }

            String[] line;
            while ((line = reader.readNext()) != null) {
                // Convert CSV row into a Student object
                Student student = new Student(
                        Integer.parseInt(line[0]),
                        line[1],
                        Integer.parseInt(line[2])
                );
                // Add to the list
                students.add(student);
            }

        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
            return null;
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numeric values: " + e.getMessage());
            return null;
        }
        //return list of student
        return students;
    }
}

