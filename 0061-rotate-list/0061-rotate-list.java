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
    static int checksize(ListNode head){
        int s = 0;
        while(head!=null){
            s++;
            head = head.next;
        }
        return s;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int size = checksize(head);
        if(size==1 || size==0 || size==k || k==0){
            return head;
        }
        ListNode temp = null;
        ListNode index = null;
        ListNode ref = head;
        for(int i = 0; i < (k%size); i++){
            temp = ref;
            index = ref.next;
            while(index.next!=null){
                temp = temp.next;
                index = index.next;
            }
            index.next = ref;
            temp.next = null;
            ref = index;
        }
        return ref;
    }
}