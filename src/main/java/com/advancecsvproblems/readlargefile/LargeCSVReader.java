package com.advancecsvproblems.readlargefile;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class LargeCSVReader {

    public static void main(String[] args) {
        String filePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\advancecsvproblems\\readlargefile\\largeFile.csv";
        processLargeCsvFile(filePath, 100);
    }

    //Method to process the file
    public static void processLargeCsvFile(String filePath, int chunkSize) {
        int totalRecordsProcessed = 0;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext(); // Read and skip the header row

            if (header == null) {
                System.out.println("CSV file is empty!");
                return;
            }

            String[] line;
            int currentChunkSize = 0;

            System.out.println("Processing large CSV file in chunks of " + chunkSize + " lines...\n");

            while ((line = reader.readNext()) != null) {
                // Process the current line (you can perform any custom logic here)
                System.out.println("Processing record: " + String.join(", ", line));

                currentChunkSize++;
                totalRecordsProcessed++;

                // When chunk size is reached, reset for the next chunk
                if (currentChunkSize == chunkSize) {
                    System.out.println("Processed " + chunkSize + " records. Total records processed so far: " + totalRecordsProcessed);
                    currentChunkSize = 0;
                }
            }

            // Print remaining records if they don't complete a full chunk
            if (currentChunkSize > 0) {
                System.out.println("Processed remaining " + currentChunkSize + " records. Total records processed: " + totalRecordsProcessed);
            }

        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}

