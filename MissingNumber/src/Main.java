public class Main {
    public static void main(String[] args) {
        int[] test1 = {3, 0, 1};
        int []test2 = {0,1};
        int []test3 = {9,6,4,2,3,5,7,0,1};
        Solution solution = new Solution();
        int res1 = solution.missingNumber(test1);
        int res2 = solution.missingNumber(test2);
        int res3 = solution.missingNumber(test3);
    }
}
