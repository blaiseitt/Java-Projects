import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] daysTillWarmer = new int[n];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
                int prevIndex = stk.pop();
                daysTillWarmer[prevIndex] = i - prevIndex;
            }
            stk.push(i);
        }

        return daysTillWarmer;
    }
}