import java.util.Stack;

class Solution {
    public int compress(char[] chars) {

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (!stack.isEmpty() &&stack.peek() != chars[i]) {
                sb.append(stack.peek());
                if (stack.size() > 1) {
                    sb.append(stack.size());
                }
                stack.clear();
            }
            stack.push(chars[i]);
        }

        if (stack.size() > 1) {
            sb.append(stack.peek());
            sb.append(stack.size());
            stack.clear();
        } else {
            sb.append(stack.peek());
            stack.clear();
        }


        String compressedChars = sb.toString();

        for (int i = 0; i < compressedChars.length(); i++) {
            chars[i] = compressedChars.charAt(i);
        }

        return compressedChars.length();
    }
}