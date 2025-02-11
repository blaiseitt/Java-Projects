import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DetermineIfTwoStringsAreCloseTest {

    Solution solution = new Solution();

    @Test
    void testCloseStrings() {
        Assertions.assertEquals(true, solution.closeStrings("abc", "bca"));
        Assertions.assertEquals(false, solution.closeStrings("a", "aa"));
        Assertions.assertEquals(true, solution.closeStrings("cabbba", "abbccc"));
    }
}
