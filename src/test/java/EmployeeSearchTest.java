import org.junit.jupiter.api.Test;

import static com.intermediatecsvproblems.employees.Employee.searchEmployee;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeSearchTest {
    @Test
    void test1(){
        String path = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\intermediatecsvproblems\\employees\\employees.csv";
        String employeeName = "Jungkook";
        boolean result = searchEmployee(path,employeeName);
        assertTrue(result);
    }

    @Test
    void test2(){
        String path = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\intermediatecsvproblems\\employees\\employees.csv";
        String employeeName = "Mon cheri";
        boolean result = searchEmployee(path,employeeName);
        assertTrue(result);
    }

    @Test
    void test3(){
        String path = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\intermediatecsvproblems\\employees\\employees.csv";
        String employeeName = "Namjoon";
        boolean result = searchEmployee(path,employeeName);
        assertTrue(result);
    }
}
