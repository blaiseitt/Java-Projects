import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeafSimilarTreesTest {

    Solution solution = new Solution();

    @Test
    void testLeafSimilar() {
        TreeNode binaryTree1 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, new TreeNode(9), new TreeNode(8)));
        TreeNode binaryTree2 = new TreeNode(3, new TreeNode(5, new TreeNode(6),
                new TreeNode(7)), new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(9), new TreeNode(8))));

        TreeNode binaryTree3 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode binaryTree4 = new TreeNode(1, new TreeNode(3), new TreeNode(2));

        TreeNode binaryTree5 = new TreeNode(1, new TreeNode(2), null);
        TreeNode binaryTree6 = new TreeNode(2, new TreeNode(2), null);

        /*Assertions.assertTrue(solution.leafSimilar(binaryTree1, binaryTree2));
        Assertions.assertFalse(solution.leafSimilar(binaryTree3, binaryTree4));*/
        Assertions.assertTrue(solution.leafSimilar(binaryTree5, binaryTree6));
    }
}
