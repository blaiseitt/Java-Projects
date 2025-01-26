import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxConsecutiveOnesTest {

    Solution solution = new Solution();

    @Test
    void testLongestOnes() {

        Assertions.assertEquals(6, solution.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        Assertions.assertEquals(10, solution.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
