import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AsteroidCollisionTest {

    Solution solution = new Solution();

    @Test
    void testAsteroidCollision() {

        Assertions.assertArrayEquals(new int[] {-2,-2,-2}, solution.asteroidCollision(new int[] {1,-2,-2,-2}));
        Assertions.assertArrayEquals(new int[] {-2,-2}, solution.asteroidCollision(new int[] {-2,-2,1,-1}));
        Assertions.assertArrayEquals(new int[] {-2,-2,-2}, solution.asteroidCollision(new int[] {-2,-2,1,-2}));
        Assertions.assertArrayEquals(new int[] {5, 10}, solution.asteroidCollision(new int[] {5, 10, -5}));
        Assertions.assertArrayEquals(new int[] {10}, solution.asteroidCollision(new int[] {10, 2, -5}));
        Assertions.assertArrayEquals(new int[] {}, solution.asteroidCollision(new int[] {8, -8}));
        Assertions.assertArrayEquals(new int[] {-2,-1,1,2}, solution.asteroidCollision(new int[] {-2,-1,1,2}));
    }
}
