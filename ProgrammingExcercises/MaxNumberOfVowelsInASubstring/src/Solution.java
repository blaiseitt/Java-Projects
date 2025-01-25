import java.util.List;

public class Solution {

    private static final String VOWELS = "aeiou";

    public int maxVowels(String s, int k) {

        int maxVowels = 0;
        int temp = 0;

        for (int i = 0; i < k; i++) {
            if (VOWELS.indexOf(s.charAt(i)) != -1) {
                temp++;
            }
        }

        maxVowels = temp;

        for (int i = k; i < s.length(); i++) {

            if (VOWELS.indexOf(s.charAt(i - k)) != -1) {
                temp--;
            }

            if (VOWELS.indexOf(s.charAt(i)) != -1) {
                temp++;
            }

            if (temp > maxVowels) {
                maxVowels = temp;
            }
        }

        return maxVowels;
    }
}
