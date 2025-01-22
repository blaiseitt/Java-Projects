import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumDepthOfBinaryTreeTest {

    Solution solution = new Solution();

    @Test
    void maximumDepthOfBinaryTreeTest() {
        //root = [3,9,20,null,null,15,7]
        TreeNode binaryTree1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        //root = [1,null,2]
        TreeNode binaryTree2 = new TreeNode(1, null, new TreeNode(2));
        int expected1 = 3;
        int expected2 = 2;

        Assertions.assertEquals(expected1, solution.maxDepth(binaryTree1));
        Assertions.assertEquals(expected2, solution.maxDepth(binaryTree2));
    }
}
