import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExcelSheetColumnNumberTest {

    private final Solution solution = new Solution();

    @Test
    void testExcelSheetNumber() {
        int expected1 = 1;
        int expected2 = 28;
        int expected3 = 701;

        int columnValue1 = solution.titleToNumber("A");
        int columnValue2 = solution.titleToNumber("AB");
        int columnValue3 = solution.titleToNumber("ZY");
        Assertions.assertEquals(expected1, columnValue1);
        Assertions.assertEquals(expected2, columnValue2);
        Assertions.assertEquals(expected3, columnValue3);
    }
}
