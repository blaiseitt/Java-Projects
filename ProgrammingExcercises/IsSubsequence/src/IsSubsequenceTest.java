import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsSubsequenceTest {

    Solution solution = new Solution();

    @Test
    void testIsSubsequence() {

        Assertions.assertEquals(true, solution.isSubsequence("abc", "ahbgdc"));
        Assertions.assertEquals(false, solution.isSubsequence("axc", "ahbgdc"));
    }
}
