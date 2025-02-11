import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemovingStarsFromStringTest {

    Solution solution = new Solution();

    @Test
    void testRemoveStars() {
        Assertions.assertEquals("", solution.removeStars("erase*****"));
        Assertions.assertEquals("lecoe", solution.removeStars("leet**cod*e"));
    }
}
