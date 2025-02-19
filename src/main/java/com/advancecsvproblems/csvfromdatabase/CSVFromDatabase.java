package com.advancecsvproblems.csvfromdatabase;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.*;

public class CSVFromDatabase {
    public static void main(String[] args) {
        // Database credentials
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/employees";
        String username = "root";
        String password = "kanchan2602";

        // Output CSV file
        String csvFile = "employee_report.csv";

        // Query to fetch employee records
        String query = "SELECT employee_id, name, department, salary FROM employees";

        try (
                // Establish database connection
                Connection connection = DriverManager.getConnection(jdbcURL, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                FileWriter writer = new FileWriter(csvFile)
        ) {
            // Write CSV headers
            writer.append("Employee ID,Name,Department,Salary\n");

            // Write data to CSV file
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");

                writer.append(String.format("%d,%s,%s,%.2f\n", employeeId, name, department, salary));
            }

            System.out.println("CSV file generated: " + csvFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

