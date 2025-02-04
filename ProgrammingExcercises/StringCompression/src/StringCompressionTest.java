import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCompressionTest {

    Solution solution = new Solution();

    @Test
    void testCompress() {
        Assertions.assertEquals(6, solution.compress(new char[]{'a','a','b','b','c','c','c'} ));
        Assertions.assertEquals(1, solution.compress(new char[]{'a'} ));
        Assertions.assertEquals(4, solution.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'} ));
    }
}
