import java.util.*;

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
        if(s.length()>15 || s.length()<1){
            return -1;
        }
        int valueOfRoman = 0;
        List<String> listOfRomanNumbers = new ArrayList<>(Arrays.asList(s.toUpperCase().split("")));
        int recentValue = romanValues.get(listOfRomanNumbers.get(0));
        for(String n: listOfRomanNumbers){
            if(!allowedValuesInOrder.contains(n)){
                return -1;
            }
            int currentValue = romanValues.get(n);
            if(currentValue <= recentValue){
                valueOfRoman += currentValue;
            }
            else{
                valueOfRoman += currentValue;
                valueOfRoman -= 2*recentValue;
            }
            recentValue = currentValue;
        }
        return valueOfRoman;
    }
}
