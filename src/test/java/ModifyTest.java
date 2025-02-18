import org.junit.jupiter.api.Test;

import static com.intermediatecsvproblems.modifyfile.ModifyCsvFile.modify;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModifyTest {
    @Test
    void test1(){
        String inputFilePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\intermediatecsvproblems\\modifyfile\\modify.csv";
        String outputFilePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\intermediatecsvproblems\\modifyfile\\modified.csv";
        boolean result = modify(inputFilePath,outputFilePath);
        assertTrue(result);
    }

    @Test
    void test2(){
        String inputFilePath = "";
        String outputFilePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\intermediatecsvproblems\\modifyfile\\modified.csv";
        boolean result = modify(inputFilePath,outputFilePath);
        assertTrue(result);
    }
}
