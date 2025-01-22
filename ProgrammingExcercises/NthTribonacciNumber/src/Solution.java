class Solution {
    public int tribonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        int d = 0;
        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }
        if (n == 2) {
            return c;
        }
        for (int i = 2; i < n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }
}
