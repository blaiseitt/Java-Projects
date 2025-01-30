import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindHighestAltitudeTest {

    Solution solution = new Solution();

    @Test
    void testLargestAltitude() {
        Assertions.assertEquals(1, solution.largestAltitude(new int[] {-5,1,5,0,-7}));
        Assertions.assertEquals(0, solution.largestAltitude(new int[] {-4,-3,-2,-1,4,3,2}));
    }
}
