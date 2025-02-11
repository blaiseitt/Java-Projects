import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {

        int l1 = word1.length();
        int l2 = word2.length();

        if (l1 != l2) return false;
        Map<Character, Integer> word1Occurrences = createOccurrencesMap(word1, l1);
        Map<Character, Integer> word2Occurrences = createOccurrencesMap(word2, l2);

        if (!word1Occurrences.keySet().equals(word2Occurrences.keySet())) return false;

        List<Integer> values1 = new ArrayList<>(word1Occurrences.values());
        List<Integer> values2 = new ArrayList<>(word2Occurrences.values());
        Collections.sort(values1);
        Collections.sort(values2);

        return values1.equals(values2);
    }

    private Map<Character, Integer> createOccurrencesMap(String word, int length) {
        Map<Character, Integer> occurrencesMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            occurrencesMap.merge(word.charAt(i), 1, Integer::sum);
        }

        return occurrencesMap;
    }
}