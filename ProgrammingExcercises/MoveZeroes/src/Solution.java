class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;

        while (right < nums.length) {
            if (nums[left] == 0) {
                if (nums[right] != 0) {
                    int temp = nums[right];
                    nums[left] = temp;
                    nums[right] = 0;
                    left++;
                } else {
                    right++;
                }
            } else {
                left++;
                right++;
            }
        }
    }
}