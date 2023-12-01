import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class ContainerWithMostWaterTest {

	private final Solution solution = new Solution();
	
	@Test
	void testContainerWithMostWater() {
		int[] testHeights = {1,8,6,2,5,4,8,3,7};
		int actual = solution.maxArea(testHeights);
		int expected = 49;
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testContainer() {
		int[] testHeights = {1,8,6,2,5,4,7,9,3};
		int actual = solution.maxArea(testHeights);
		int expected = 48;
		
		assertEquals(expected, actual);
	}
	
}
