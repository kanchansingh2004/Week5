package com.basiccsvproblems.readcsvfile;
import java.io.*;

public class ReadCSVFile {
    public static void main(String[] args) {
        //Store the file path
        String filePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\basiccsvproblems\\readcsvfile\\read.csv";
        readFile(filePath);
    }

    public static boolean readFile(String filePath) {
        boolean result = false;
        //Using Try and catch block to handle exception(If any)
        try{
            //Create file and buffer reader to read from a CSV file
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            //Run a whie loop to print the file data using string array
            while(line!=null){
                String[] columns = line.split(",");
                System.out.println(columns[0] + ", " + columns[1] + ", " + columns[2] + ", " + columns[3]);
                line = bufferedReader.readLine();
            }

            result = true;
        }catch (IOException e){
            //Print message
            e.printStackTrace();
        }

        return result;
    }
}
