import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxNumberOfVowelsInASubstringTest {

    Solution solution = new Solution();

    @Test
    void testMaxNumberOfVowels() {
        String example1 = "abciiidef";
        int k1 = 3;

        String example2 = "aeiou";
        int k2 = 2;

        Assertions.assertEquals(3, solution.maxVowels(example1, k1));
        Assertions.assertEquals(2, solution.maxVowels(example2, k2));
        Assertions.assertEquals(4, solution.maxVowels("weallloveyou", 7));
        Assertions.assertEquals(1, solution.maxVowels("a", 1));
    }
}
