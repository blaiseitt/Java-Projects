import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            nums1Set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2Set.add(nums2[i]);
        }
        List<Integer> distinctNums1 = new ArrayList<>();
        List<Integer> distinctNums2 = new ArrayList<>();

        for (int n : nums1Set) {
            if (!nums2Set.contains(n)) distinctNums1.add(n);
        }
        for (int n : nums2Set) {
            if (!nums1Set.contains(n)) distinctNums2.add(n);
        }

        return List.of(distinctNums1, distinctNums2);
    }
}