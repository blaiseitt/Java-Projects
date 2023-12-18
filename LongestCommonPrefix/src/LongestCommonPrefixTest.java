import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LongestCommonPrefixTest {

	private final Solution solution = new Solution();
	
	@Test
	void test1() {
		String expected = "fl";
		String[] strs = {"flower", "flow", "flight"};
		
		assertEquals(expected, solution.longestCommonPrefix(strs));
	}
	
	@Test
	void test2() {
		String expected = "";
		String[] strs = {"dog", "racecar", "car"};
		
		assertEquals(expected, solution.longestCommonPrefix(strs));
	}
	
	@Test
	void test3() {
		String expected = "";
		String[] strs = {""};
		
		assertEquals(expected, solution.longestCommonPrefix(strs));
	}
	
	@Test
	void test4() {
		String expected = "flower";
		String[] strs = {"flower","flower","flower","flower"};
		
		assertEquals(expected, solution.longestCommonPrefix(strs));
	}
	
	@Test
	void test4() {
		String expected = "a";
		String[] strs = {"a","ac"};
		
		assertEquals(expected, solution.longestCommonPrefix(strs));
	}

}
