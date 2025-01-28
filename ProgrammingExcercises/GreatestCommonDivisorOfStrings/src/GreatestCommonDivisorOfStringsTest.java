import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GreatestCommonDivisorOfStringsTest {

    Solution solution = new Solution();

    @Test
    void testGcdOfStrings() {

        Assertions.assertEquals("ABC", solution.gcdOfStrings("ABCABC", "ABC"));
        Assertions.assertEquals("AB", solution.gcdOfStrings("ABABAB", "ABAB"));
        Assertions.assertEquals("", solution.gcdOfStrings("LEET", "CODE"));
    }
}
