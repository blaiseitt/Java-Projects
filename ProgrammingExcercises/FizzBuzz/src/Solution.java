import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<Integer> listOfIntegers = createListOfIntegers(n);
        List<String> out = new ArrayList<>();
        for(int i : listOfIntegers){
            if(i%3==0 && i%5==0){
                out.add("FizzBuzz");
            } else if (i%3==0) {
                out.add("Fizz");
            }else if(i%5==0){
                out.add("Buzz");
            }else{
                out.add(Integer.toString(i));
            }
        }
        return out;
    }

    private static List<Integer> createListOfIntegers(int n){
        List<Integer>list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            list.add(i);
        }
        return list;
    }
}
