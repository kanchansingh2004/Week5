import org.junit.jupiter.api.Test;
import static com.basiccsvproblems.readcsvfile.ReadCSVFile.readFile;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadCSVFileTest {
    @Test
    void test1(){
        String filePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\basiccsvproblems\\readcsvfile\\read.csv";
        boolean result = readFile(filePath);
        assertTrue(result);
    }

    @Test
    void test2(){
        String filePath = "";
        boolean result = readFile(filePath);
        assertTrue(result);
    }
}
