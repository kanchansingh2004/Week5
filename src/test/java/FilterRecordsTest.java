import org.junit.jupiter.api.Test;

import static com.intermediatecsvproblems.filterrecords.FilterRecords.filteredStudents;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterRecordsTest {
    @Test
    void test1(){
        String path = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\intermediatecsvproblems\\filterrecords\\FilterRecords.csv";
        int result = filteredStudents(path);
        assertEquals(3, result);
    }

    @Test
    void test2(){
        String path = "";
        int result = filteredStudents(path);
        assertEquals(3, result);
    }
}
