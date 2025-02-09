import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindDifferenceOfTwoArraysTest {

    Solution solution = new Solution();

    @Test
    void testFindDifference() {
        Assertions.assertEquals(List.of(List.of(1, 3), List.of(4, 6)), solution.findDifference(new int[] {1, 2, 3}, new int[] {2, 4, 6}));
        Assertions.assertEquals(List.of(List.of(3), new ArrayList<>()), solution.findDifference(new int[] {1, 2, 3, 3}, new int[] {1, 1, 2, 2}));
    }
}
