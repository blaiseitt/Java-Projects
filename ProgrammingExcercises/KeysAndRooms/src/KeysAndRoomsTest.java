import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class KeysAndRoomsTest {

    Solution solution = new Solution();

    @Test
    void testCanVisitAllRooms() {
        Assertions.assertTrue(solution.canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), new ArrayList<>())));
        Assertions.assertFalse(solution.canVisitAllRooms(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0))));
    }
}
