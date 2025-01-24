public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        for (int i = k; i < nums.length; i++) {
            maxSum = Math.max(maxSum, windowSum);
            windowSum += nums[i] - nums[i-k];
        }
        maxSum = Math.max(maxSum, windowSum);

        double average = maxSum/(double)k;

        return average;
    }
}