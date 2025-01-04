public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] solution = new int[2];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    solution[0] = i;
                    solution[1] = j;
                }
            }
        }
        return solution;
    }
}
