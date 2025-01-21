import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private static final List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public String reverseVowels(String s) {
        char[] letters = s.toCharArray();
        char[] reversedLetters = Arrays.copyOf(letters, letters.length);
        List<Integer> vowelsIndexes = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            if (vowels.contains(letters[i])) {
                vowelsIndexes.add(i);
            }
        }
        while (vowelsIndexes.size() > 1) {
            reversedLetters[vowelsIndexes.getLast()] = letters[vowelsIndexes.getFirst()];
            reversedLetters[vowelsIndexes.getFirst()] = letters[vowelsIndexes.getLast()];

            vowelsIndexes.removeFirst();
            vowelsIndexes.removeLast();
        }

        return new String(reversedLetters);
    }
}
