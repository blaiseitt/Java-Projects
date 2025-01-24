class Solution {
    public int search(int[] nums, int target) {

        int a = 0;
        int c = nums.length;
        int i;

        while (a <= c) {
            i = Math.floorDiv(a + c, 2);
            if (nums[i] < target) a = i + 1;
            else if (nums[i] > target) c = i - 1;
            else return i;
        }
        return -1;
    }
}
