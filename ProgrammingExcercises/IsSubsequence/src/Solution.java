class Solution {
    public boolean isSubsequence(String s, String t) {
        int goalPointer = 0;
        int sl = s.length();
        int tl = t.length();

        if (sl == 0) return true;
        if (tl == 0) return false;

        for (int i = 0; i < tl; i++) {
            if (t.charAt(i) == s.charAt(goalPointer)) {
                goalPointer++;
                if (goalPointer == sl) return true;
            }
        }
        return false;
    }
}