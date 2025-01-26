class Solution {

    public int longestOnes(int[] nums, int k) {

        int left = 0, right = 0, zerosCount = 0;
        int longestOnes = 0;

        while (right < nums.length) {
            if (nums[right] == 0) zerosCount++;

            if (zerosCount > k) {
                if (nums[left] == 0) zerosCount--;
                left++;
            }

            longestOnes = Math.max(right - left + 1, longestOnes);
            right++;
        }

        return longestOnes;
    }
}
