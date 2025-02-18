import org.junit.jupiter.api.Test;
import static com.basiccsvproblems.readandcount.ReadAndCount.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReadAndCountTest {
    @Test
    void test1(){
        String filePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\basiccsvproblems\\readcsvfile\\read.csv";
        int result = countTheRecords(filePath);
        assertEquals(3,result);
    }

    @Test
    void test2(){
        String filePath = "";
        int result = countTheRecords(filePath);
        assertEquals(-1,result);
    }
}
