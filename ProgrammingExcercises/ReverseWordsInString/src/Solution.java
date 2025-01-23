import java.util.Arrays;
import java.util.List;

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\s+");
        List<String> filteredWords = Arrays.stream(words).filter(w -> !w.isBlank()).toList();
        StringBuilder sb = new StringBuilder();
        for (int i = filteredWords.size() - 1; i >= 0; i--) {
            sb.append(filteredWords.get(i) + " ");
        }
        return sb.toString().trim();
    }
}
