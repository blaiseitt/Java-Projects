import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrencesMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            occurrencesMap.merge(arr[i], 1, Integer::sum);
        }

        int mapSize = occurrencesMap.size();
        int uniqueValues = (int) occurrencesMap.values().stream().distinct().count();

        return mapSize == uniqueValues;
    }
}