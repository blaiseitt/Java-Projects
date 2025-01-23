import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseWordsInStringTest {

    Solution solution = new Solution();

    @Test
    void testReverseWordsInString() {
        String actual1 = solution.reverseWords("the sky is blue");
        String actual2 = solution.reverseWords("  hello world  ");
        String actual3 = solution.reverseWords("a good   example");

        String expected1 = "blue is sky the";
        String expected2 = "world hello";
        String expected3 = "example good a";

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        Assertions.assertEquals(expected3, actual3);
    }
}
