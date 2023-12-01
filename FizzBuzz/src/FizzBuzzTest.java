import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class FizzBuzzTest {

	private final Solution solution = new Solution();
	
	@Test
	void testFizzBuzzSolution() {
		List<String> expected = new ArrayList<String>(
				Arrays.asList("1", "2", "Fizz", "4", "Buzz", 
						"Fizz", "7", "8", "Fizz", "Buzz", 
						"11", "Fizz", "13", "14", "FizzBuzz"));
		
		List<String> actual = solution.fizzBuzz(15);
		assertEquals(expected, actual);
	}

}
