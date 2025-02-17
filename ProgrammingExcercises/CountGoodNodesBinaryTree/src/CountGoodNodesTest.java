import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountGoodNodesTest {

    Solution solution = new Solution();

    @Test
    void testGoodNodes() {
        TreeNode example1 = new TreeNode(3, new TreeNode(1, new TreeNode(3), null),
                new TreeNode(4, new TreeNode(1), new TreeNode(5)));
        TreeNode example2 = new TreeNode(3, new TreeNode(3, new TreeNode(4), new TreeNode(2)), null);
        TreeNode example3 = new TreeNode(2, null,
                new TreeNode(4, new TreeNode(10), new TreeNode(8, new TreeNode(4), null)));

        Assertions.assertEquals(4, solution.goodNodes(example1));
        Assertions.assertEquals(3, solution.goodNodes(example2));
        Assertions.assertEquals(4, solution.goodNodes(example3));
    }
}
