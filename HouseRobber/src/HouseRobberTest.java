import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HouseRobberTest {
	
	private final Solution solution = new Solution();

	@Test
	void testHouseRobber() {
		int[] nums = {2,3,5,9};
		int k = 2;
		int expected = 5;
		
		int[] nums2 = {2,7,9,3,1};
		int k2 = 2;
		int expected2 = 2;
		
		assertEquals(expected, solution.minCapability(nums, k));
		assertEquals(expected, solution.minCapability(nums2, k2));
	}

}
