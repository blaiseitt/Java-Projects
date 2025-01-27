import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeStringsAlternatelyTest {

    Solution solution = new Solution();

    @Test
    void testMergeAlternately() {

        Assertions.assertEquals("apbqcr", solution.mergeAlternately("abc", "pqr"));
        Assertions.assertEquals("apbqrs", solution.mergeAlternately("ab", "pqrs"));
        Assertions.assertEquals("apbqcd", solution.mergeAlternately("abcd", "pq"));
    }
}
