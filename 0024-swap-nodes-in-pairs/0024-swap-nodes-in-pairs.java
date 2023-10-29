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
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode temp1 = head;
        ListNode temp2 = head.next.next;
        ListNode temp3 = temp1;
        head = head.next;
        head.next = temp1;
        temp1.next = temp2;
        while(temp2 != null){
            temp1 = temp1.next;
            if(temp2 == null) return head;
            if(temp2.next == null) return head;
            temp2 = temp2.next.next;
            temp3.next = temp1.next;
            temp3 = temp1.next;
            temp3.next = temp1;
            temp1.next = temp2;
            temp3 = temp1;
        }
        return head;
    }
}