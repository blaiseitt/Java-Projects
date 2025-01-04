import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {
        Map<String, String> digitToLetter = new HashMap<>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};

        List<String> combinations = new ArrayList<String>();
        int length = digits.length();

        for(int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            combinations = getSeparateLetters(digitToLetter, String.valueOf(c), combinations);
        }

        return combinations;
    }

    private List<String> getSeparateLetters(Map<String, String> digit2Letter, String digit, List<String> combinations) {
        String letters = digit2Letter.get(digit);
        List<String> output = new ArrayList<>();
        if(combinations.size()>0) {
            for(int j = 0; j < combinations.size(); j++) {
                for(int i = 0; i < letters.length(); i++) {
                    char c = letters.charAt(i);
                    output.add(combinations.get(j)+String.valueOf(c));
                }
            }
            return output;
        } else {
            for(int i = 0; i < letters.length(); i++) {
                char c = letters.charAt(i);
                combinations.add(String.valueOf(c));
            }
            return combinations;
        }
    }
}