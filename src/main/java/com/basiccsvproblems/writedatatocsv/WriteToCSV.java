package com.basiccsvproblems.writedatatocsv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToCSV {
    public static void main(String[] args) {
        //Store the file path
        String filePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\basiccsvproblems\\writedatatocsv\\write.csv";
        //Print the message
        if(writeToCsv(filePath)){
            // Indicating success
            System.out.println("CSV file written successfully!");
        }
    }

    public static boolean writeToCsv(String filePath) {
        boolean result = false;
        //Using Try and catch block to handle exception(If any)
        try (
                FileWriter writer = new FileWriter(filePath);
                BufferedWriter bufferedWriter = new BufferedWriter(writer)
        ) {
            // Writing headers
            bufferedWriter.write("ID, Name, Department, Salary");
            bufferedWriter.newLine(); // Move to the next line

            // Writing data rows
            bufferedWriter.write("011, Kuchu, Developer, 50000");
            bufferedWriter.newLine();
            bufferedWriter.write("012, Loona, Finance, 30000");
            bufferedWriter.newLine();
            bufferedWriter.write("013, Mon cheri, HR, 23000");
            bufferedWriter.newLine();
            bufferedWriter.write("014, Jungkook, Social Media, 60000");
            bufferedWriter.newLine();
            bufferedWriter.write("015, Taehyung, Social Media, 70000");
            bufferedWriter.newLine();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        //return result
        return result;
    }
}
