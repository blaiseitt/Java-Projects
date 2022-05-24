import java.util.*;

public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();
        List<String> XD = solution.allowedValuesInOrder;
        System.out.print(XD.indexOf("X"));
        int value = solution.romanToInt(args[0]);
    }
}
