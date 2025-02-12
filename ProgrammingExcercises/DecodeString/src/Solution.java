import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public String decodeString(String s) {

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (stk.peek() != '[') {
                    sb.append(stk.pop());
                }
                //pop [ , reverse string, retrieve number of repetitions and repeat
                stk.pop();
                sb.reverse();

                StringBuilder repeatSb = new StringBuilder();
                while (!stk.isEmpty() && Character.isDigit(stk.peek())) {
                    repeatSb.append(stk.pop());
                }
                int repetitions = Integer.parseInt(repeatSb.reverse().toString());
                String temp = sb.toString();
                for (int j = 1; j < repetitions; j++) {
                    sb.append(temp);
                }
                temp = sb.toString();
                for (int j = 0; j < temp.length(); j++) {
                    stk.push(temp.charAt(j));
                }
            } else {
                stk.push(c);
            }
        }

        return stk.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}