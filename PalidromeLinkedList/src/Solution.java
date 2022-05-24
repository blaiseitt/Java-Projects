import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> listOfElements = new ArrayList<>();
        while(true){
            try{
                int value = head.val;
                head = head.next;
                listOfElements.add(value);
            }
            catch (NullPointerException e){
                break;
            }
        }

        //reverse list
        List<Integer> reversedListOfElements = new ArrayList<>();
        int numberOfElements = listOfElements.size();
        for(int i = numberOfElements-1; i>=0; i--){
            reversedListOfElements.add(listOfElements.get(i));
        }
        System.out.print(listOfElements);
        System.out.print(reversedListOfElements);
        if(reversedListOfElements.equals(listOfElements))
            return true;
        return false;
    }
}