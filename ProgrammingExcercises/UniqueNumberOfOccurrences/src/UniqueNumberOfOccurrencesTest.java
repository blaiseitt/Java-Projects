import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UniqueNumberOfOccurrencesTest {

    Solution solution = new Solution();

    @Test
    void testUniqueOccurrences() {
        Assertions.assertEquals(true, solution.uniqueOccurrences(new int[] {1, 2, 2, 1, 1, 3}));
        Assertions.assertEquals(false, solution.uniqueOccurrences(new int[] {1, 2}));
        Assertions.assertEquals(true, solution.uniqueOccurrences(new int[] {-3,0,1,-3,1,1,1,-3,10,0}));
    }
}
