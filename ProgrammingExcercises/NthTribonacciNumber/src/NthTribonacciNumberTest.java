import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NthTribonacciNumberTest {

    Solution solution = new Solution();

    @Test
    void testNthTribonacciNumber() {
        int actual1 = solution.tribonacci(4);
        int expected1 = 4;
        int actual2 = solution.tribonacci(25);
        int expected2 = 1389537;

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }
}
