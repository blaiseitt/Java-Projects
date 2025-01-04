import java.util.Map;
import java.util.Stack;

class Solution {
	
	Map<String, String> parantheses = Map.of("(", ")",
											"{", "}",
											"[", "]");
	
    public boolean isValid(String s) {
        if (s.length( )% 2 == 1) {
        	return false;
        }
        
        Stack<String> stack = new Stack<String>();
        
        for(char c : s.toCharArray()) {
        	if (c == '(' || c == '{' || c == '[') {
        		stack.push(parantheses.get(String.valueOf(c)));
        	} else if (c == ')' || c == '}' || c == ']') {
        		if (stack.empty()) {
        			return false;
        		}
        		if (c != stack.pop().charAt(0)) {
        			return false;
        		}
        	} else {
        		return false;
        	}
        }
        
        if (stack.empty()) {
        	return true;
        } else {
        	return false;
        }       
    }
}