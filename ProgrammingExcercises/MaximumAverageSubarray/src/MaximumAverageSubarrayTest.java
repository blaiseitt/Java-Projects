import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumAverageSubarrayTest {

    Solution solution = new Solution();

    @Test
    void testMaximumAverageSubarray() {
        /*int[] nums1 = {1,12,-5,-6,50,3};
        int k1 = 4;
        double actual1 = solution.findMaxAverage(nums1, k1);

        int[] nums2 = {5};
        int k2 = 1;
        double actual2 = solution.findMaxAverage(nums2, k2);
        double expected1 = 12.75;
        double expected2 = 5.0;*/

        int[] nums3 = {9,7,3,5,6,2,0,8,1,9};
        int k3 = 6;
        double actual3 = solution.findMaxAverage(nums3, k3);
        double expected3 = 5.3333;
        Assertions.assertEquals(expected3, actual3);

        /*Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);*/
    }
}
