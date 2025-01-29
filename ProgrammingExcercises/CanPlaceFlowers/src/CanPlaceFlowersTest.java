import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CanPlaceFlowersTest {

    Solution solution = new Solution();

    @Test
    void testCanPlaceFlowers() {
        Assertions.assertEquals(true, solution.canPlaceFlowers(new int[] {1, 0, 0, 0, 1}, 1));
        Assertions.assertEquals(false, solution.canPlaceFlowers(new int[] {1, 0, 0, 0, 1}, 2));
        Assertions.assertEquals(true, solution.canPlaceFlowers(new int[] {0, 0, 1, 0, 0}, 2));
        Assertions.assertEquals(true, solution.canPlaceFlowers(new int[] {0, 0, 0, 0, 1, 0}, 2));
        Assertions.assertEquals(true, solution.canPlaceFlowers(new int[] {0, 1, 0, 0, 0, 0}, 2));
    }
}
