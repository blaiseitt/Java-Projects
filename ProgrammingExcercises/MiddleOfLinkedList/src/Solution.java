class Solution {
    public ListNode middleNode(ListNode head) {
        int numberOfElements = 0;

        ListNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.next;
            numberOfElements++;
        }
        int nodeIndex = 0;
        currentNode = head;
        while(nodeIndex <= (numberOfElements/2)){
            if(numberOfElements>1) currentNode = currentNode.next;
            nodeIndex++;
        }
        return currentNode;
    }
}
