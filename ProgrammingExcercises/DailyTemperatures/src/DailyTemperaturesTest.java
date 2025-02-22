import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DailyTemperaturesTest {

    Solution solution = new Solution();

    @Test
    void testDailyTemperatures() {
        Assertions.assertArrayEquals(new int[] {1,1,4,2,1,1,0,0}, solution.dailyTemperatures(new int[] {73,74,75,71,69,72,76,73}));
        Assertions.assertArrayEquals(new int[] {1,1,1,0}, solution.dailyTemperatures(new int[] {30,40,50,60}));
        Assertions.assertArrayEquals(new int[] {1,1,0}, solution.dailyTemperatures(new int[] {30,60,90}));
    }
}
