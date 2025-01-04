import java.util.Arrays;

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;

        for(int i =0; i < length; i++){
           if(nums[i]!=i)return i;
        }
        return nums[length-1]+1;
    }
}