public class Solution {
	
	public int maxArea(int[] height) {
		
		int leftPointer = 0;
		int rightPointer = height.length - 1;
		int size = height.length;
		int area = 0;
		
		while (leftPointer < rightPointer) {
			int length = Math.abs(rightPointer - leftPointer);
			int width = Math.min(height[rightPointer], height[leftPointer]);
			area = Math.max(area, length*width);
			
			if (height[leftPointer] < height[rightPointer]) {
				leftPointer++;
			} else {
				rightPointer--;
			}
		}
		
		return area;
	}
}
