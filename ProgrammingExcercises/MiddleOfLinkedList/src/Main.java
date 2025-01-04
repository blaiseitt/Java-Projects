public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode head0 = new ListNode(1);
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));
        solution.middleNode(head0);
        solution.middleNode(head1);
        solution.middleNode(head2);
        solution.middleNode(head3);
    }
}
