import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecodeStringTest {

    Solution solution = new Solution();

    @Test
    void testDecodeString() {

        Assertions.assertEquals("aaabcbc", solution.decodeString("3[a]2[bc]"));
        Assertions.assertEquals("accaccacc", solution.decodeString("3[a2[c]]"));
        Assertions.assertEquals("abcabccdcdcdef", solution.decodeString("2[abc]3[cd]ef"));
    }
}
