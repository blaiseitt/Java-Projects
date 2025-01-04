import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

	private static final Solution solution = new Solution();
	
	@Test
	void testBinarySearchWantedNumberExists() {
		int[] test = new int []{1,2,3,4,5,6,7,8,9};
		
		assertEquals(solution.search(test, 7), 6);
	}
	
	@Test
	void testBinarySearchWantedNumberNotExists() {
        int[] test = new int []{1,2,4,6,11,22,23,25};
        
        assertEquals(solution.search(test, 3), -1);
	}

}
