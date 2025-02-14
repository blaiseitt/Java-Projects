import java.util.Arrays;

class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        int i = 0;
        int j = nums.length - 1;
        Arrays.sort(nums);

        while (i < j) {
            if (nums[i] + nums[j] == k) {
                i++;
                j--;
                count++;
            } else if (nums[i] + nums[j] < k) {
                i++;
            } else {
                j--;
            }
        }
        
        return count;
    }
}