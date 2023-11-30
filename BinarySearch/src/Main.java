public class Main {
    public static void main(String[] args) {
        int[] test1 = new int []{1,2,3,4,5,6,7,8,9};
        int[] test2 = new int []{1,2,4,6,11,22,23,25};

        Solution solution = new Solution();
        System.out.println(solution.search(test1, 7));
        System.out.println(solution.search(test2, 3));
    }
}
