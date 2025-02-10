import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stk.push(asteroids[i]);
            }
            else {
                if (stk.isEmpty() || stk.peek() < 0) {
                    stk.push(asteroids[i]);
                } else {
                    while (!stk.isEmpty()) {
                        if (stk.peek() < 0) {
                            stk.push(asteroids[i]);
                            break;
                        }
                        int collisionResult = stk.peek() + asteroids[i];
                        if (collisionResult < 0) {
                            if (stk.peek() > 0) {
                                stk.pop();
                                if (stk.isEmpty() || stk.peek() < 0) {
                                    stk.push(asteroids[i]);
                                    break;
                                }
                            }
                        } else if (collisionResult == 0) {
                            stk.pop();
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return stk.stream().mapToInt(i -> i).toArray();
    }
}