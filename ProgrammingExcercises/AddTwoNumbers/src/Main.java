public class Main {
    public static void main(String[] args) {
        /*ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode head11 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head22 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));*//*
        Solution solution = new Solution();
       *//* ListNode result1 = solution.addTwoNumbers(head1, head11);
        ListNode result2 = solution.addTwoNumbers(head2, head22);*//*
        ListNode head0 = new ListNode(0);
        ListNode head00 = new ListNode(0);
        ListNode head3 = new ListNode(9);
        ListNode head33 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        ListNode result3 = solution.addTwoNumbers(head3, head33);

        createLinkedList(1000000000000000000000000000001);*/
        System.out.println(1_001.11);
        int [][] array1 = new int[1][2];
        System.out.print(array1.toString());
    }

    private static ListNode createLinkedList(long val) {
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
