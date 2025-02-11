import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public String removeStars(String s) {

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                stk.pop();
            }else {
                stk.push(s.charAt(i));
            }
        }

        return stk.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
    }
}