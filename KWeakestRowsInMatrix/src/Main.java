public class Main {
    public static void main(String[] args) {
        int[][] test1 = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int[][] test2 = {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        int[][] test3 = {{1, 0}, {1, 0}, {1, 0}, {1, 1}};

        Solution solution = new Solution();
        //int[] hmm1 = solution.kWeakestRows(test1, 3);
        //int[] hmm2 = solution.kWeakestRows(test2, 4);
        int[] hmm3 = solution.kWeakestRows(test3, 4);
    }
}
