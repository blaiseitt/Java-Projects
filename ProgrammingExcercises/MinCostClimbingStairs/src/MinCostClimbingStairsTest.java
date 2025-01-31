import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinCostClimbingStairsTest {

    Solution solution = new Solution();

    @Test
    void testMinCostClimbingStairs() {
        Assertions.assertEquals(15, solution.minCostClimbingStairs(new int[] {10, 15, 20}));
        Assertions.assertEquals(6, solution.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
