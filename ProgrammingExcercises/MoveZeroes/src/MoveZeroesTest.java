import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoveZeroesTest {

    Solution solution = new Solution();


    @Test
    void testMoveZeroes() {
        int[] example1 = new int[] {0};
        solution.moveZeroes(example1);
        int[] example2 = new int[] {0, 1, 0, 3, 12};
        solution.moveZeroes(example2);

        Assertions.assertArrayEquals(new int[] {0}, example1);
        Assertions.assertArrayEquals(new int[] {1, 3, 12, 0, 0}, example2);
    }
}
