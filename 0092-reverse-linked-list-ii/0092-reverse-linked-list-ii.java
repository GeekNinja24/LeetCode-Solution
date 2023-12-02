/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left_before = dummy;
        ListNode right_node = dummy;
        ListNode right_next;
        ListNode left_node;
        for(int i=1;i<left;i++){
            left_before = left_before.next;
        }
        for(int i=0;i<right;i++){
            right_node = right_node.next;
        }
        right_next = right_node.next;
        left_node = left_before.next;
        right_node.next= null;
        left_before.next = reverseList(left_node);
        left_node.next = right_next;
        return dummy.next;
    }

     public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode next =curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}