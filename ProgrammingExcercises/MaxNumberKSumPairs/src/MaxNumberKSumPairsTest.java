import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxNumberKSumPairsTest {

    Solution solution = new Solution();

    @Test
    void testMaxNumberKSumPairs() {
        Assertions.assertEquals(2, solution.maxOperations(new int[] {1, 2, 3, 4}, 5));
        Assertions.assertEquals(1, solution.maxOperations(new int[] {3, 1, 3, 4, 3}, 6));
    }
}
