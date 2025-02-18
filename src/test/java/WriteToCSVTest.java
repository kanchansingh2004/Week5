import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.basiccsvproblems.writedatatocsv.WriteToCSV.writeToCsv;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WriteToCSVTest {
    @Test
    void test1(){
        String filePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\basiccsvproblems\\writedatatocsv\\write.csv";
        assertTrue(writeToCsv(filePath));
    }

    @Test
    void test2(){
        String filePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\basiccsvproblems\\writedatatocsv\\write2.csv";
        assertTrue(writeToCsv(filePath));
    }

    @Test
    void test3(){
        String filePath = "";
        assertThrows(IOException.class, () -> writeToCsv(filePath));
    }
}
