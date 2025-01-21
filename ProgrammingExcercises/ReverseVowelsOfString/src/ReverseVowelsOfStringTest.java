import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseVowelsOfStringTest {

    Solution solution = new Solution();

    @Test
    void testReverseVowelsOfString() {
        String input1 = "IceCreAm";
        String input2 = "leetcode";
        String expected1 = "AceCreIm";
        String expected2 = "leotcede";

        Assertions.assertEquals(expected1, solution.reverseVowels(input1));
        Assertions.assertEquals(expected2, solution.reverseVowels(input2));
    }
}
