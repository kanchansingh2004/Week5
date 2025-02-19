import org.junit.jupiter.api.Test;

import static com.advancecsvproblems.databeforeprocess.CSVValidator.validateCsv;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVValidatorTest {

    @Test
    void testValidCsv() {
        String filePath = "D:\\Training_Capgemini\\Week5\\Day1\\src\\main\\java\\com\\advancecsvproblems\\databeforeprocess\\employees.csv";
        assertTrue(validateCsv(filePath)); // Expecting a valid CSV
    }

    @Test
    void testInvalidPhoneNumbers() {
        String filePath = "";
        boolean result = validateCsv(filePath);
        assertTrue(!result);
    }
}

