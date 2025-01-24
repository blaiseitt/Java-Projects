import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long sum = getStoredValue(l1) + getStoredValue(l2);
        ListNode out = createLinkedList(sum);
        return out;
    }

    private long getStoredValue(ListNode l) {
        List<Integer> reversedValues = new ArrayList<>();
        while (true) {
            if (l.next == null) {
                reversedValues.add(l.val);
                break;
            }
            reversedValues.add(l.val);
            l = l.next;
        }
        //Collections.reverse(reversedValues);
        long actualValue = 0;
        for (int i = 0; i < reversedValues.size(); i++) {
            long x = (long) Math.pow(10, i);
            actualValue += x * reversedValues.get(i);
        }
        return actualValue;
    }

    private ListNode createLinkedList(long val) {
        ListNode l = new ListNode(0);
        ListNode temp = l;
        if (val == 0) return l;
        while (val > 0) {
            temp.next = new ListNode((int)(val % 10));
            temp = temp.next;
            val /= 10;
        }
        return l.next;
    }
}
