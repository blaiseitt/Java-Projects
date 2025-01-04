import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidParanthesesTest {
	
	private final Solution solution = new Solution();

	@Test
	void test1() {
		boolean expected = true;
		String input = "()";
		assertEquals(expected, solution.isValid(input));
	}
	
	@Test
	void test2() {
		boolean expected = true;
		String input = "()[]{}";
		assertEquals(expected, solution.isValid(input));
	}
	
	@Test
	void test3() {
		boolean expected = false;
		String input = "(]";
		assertEquals(expected, solution.isValid(input));
	}

}
