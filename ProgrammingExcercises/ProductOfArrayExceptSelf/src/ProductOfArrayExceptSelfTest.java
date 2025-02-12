import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductOfArrayExceptSelfTest {

    Solution solution = new Solution();

    @Test
    void testProductExceptSelf() {
        Assertions.assertArrayEquals(new int[] {24, 12, 8, 6}, solution.productExceptSelf(new int[] {1, 2, 3, 4}));
        Assertions.assertArrayEquals(new int[] {0, 0, 9, 0, 0}, solution.productExceptSelf(new int[] {-1, 1, 0, -3, 3}));
    }
}
