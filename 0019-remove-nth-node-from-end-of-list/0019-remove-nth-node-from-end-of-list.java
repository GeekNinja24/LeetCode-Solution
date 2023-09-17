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
      public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int size =1;
        while(temp.next!=null){
            size++;
            temp=temp.next;
        }

        if(size==n){
            head=head.next;
            return head;
        }

        int rev = size-n;

        int index =1;
        ListNode temp1=head;

            while (index < rev) {
                  index++;
                temp1 = temp1.next;
                
            }
            temp1.next = temp1.next.next;

        return head;
    }
}