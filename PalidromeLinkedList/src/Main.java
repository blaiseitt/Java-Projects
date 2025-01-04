public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode headPalidrome = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode headNotPalidrome1 = new ListNode(1, new ListNode(3, new ListNode(2, new ListNode(1))));
        ListNode headNotPalidrome2 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2))));
        System.out.println(solution.isPalindrome(headPalidrome));
        System.out.println(solution.isPalindrome(headNotPalidrome1));
        System.out.println(solution.isPalindrome(headNotPalidrome2));
    }
}