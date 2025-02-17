class Solution {
    private int count = 0;
    public int goodNodes(TreeNode root) {
        int maxValue = root.val;
        count = 0;
        countGoodNodes(maxValue, root);

        return count;
    }

    private void countGoodNodes(int maxValue, TreeNode root) {
        if (root == null) return;
        if (root.val >= maxValue) {
            maxValue = root.val;
            count++;
        }
        if (root.left == null && root.right == null) return;
        countGoodNodes(maxValue, root.left);
        countGoodNodes(maxValue, root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
