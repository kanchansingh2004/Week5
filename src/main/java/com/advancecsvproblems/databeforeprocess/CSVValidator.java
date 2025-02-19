package com.advancecsvproblems.databeforeprocess;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class CSVValidator {

    public static void main(String[] args) {
        // Path to the CSV file to validate
        String filePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\advancecsvproblems\\databeforeprocess\\employees.csv";

        // Validate the CSV file and print results
        if (validateCsv(filePath)) {
            System.out.println("CSV file is valid!");
        } else {
            System.out.println("CSV file has invalid data.");
        }
    }

    // Validate the CSV data for email and phone number formats
    public static boolean validateCsv(String filePath) {
        boolean isValid = true;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext(); // Read the header row
            if (header == null) {
                System.out.println("CSV file is empty!");
                return false;
            }

            String[] line;
            //Loop through each line
            while ((line = reader.readNext()) != null) {
                String email = line[2].trim();
                String phone = line[3].trim();

                // Validate email
                if (!isValidEmail(email)) {
                    System.out.println("Invalid email: " + email);
                    isValid = false;
                }

                // Validate phone number
                if (!isValidPhoneNumber(phone)) {
                    System.out.println("Invalid phone number: " + phone);
                    isValid = false;
                }
            }

        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
            return false;
        }

        //return the result
        return isValid;
    }

    // Validate email format using regex
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }

    // Validate phone number format (10 digits)
    private static boolean isValidPhoneNumber(String phone) {
        String phoneRegex = "\\d{10}";
        return Pattern.matches(phoneRegex, phone);
    }
}

