import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    List<String> allowedValuesInOrder = Arrays.asList("I", "V", "X", "L", "C", "D", "M");

    Map<String, Integer> romanValues = new HashMap<String, Integer>(){{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
    }};



    public int romanToInt(String s) {
        for(char n: s.toUpperCase().toCharArray()){
            System.out.print(n);
        }
        return 3;
    }
}

