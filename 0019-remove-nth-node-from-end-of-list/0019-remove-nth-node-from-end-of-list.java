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
        ListNode pointer = head;
        ListNode before = head;

        if (length(head) == n){
            head = head.next;
            return head;
        }
        if (length(head) == 1){
            return null;
        }
        if (n == 1){
            for (int i = 0; i < length(head)-n-1; i++){
            pointer = pointer.next;
            before = before.next;
            }
            before.next = null;
            return head;
        }
       
        pointer = pointer.next;
        for (int i = 0; i < length(head)-n-1; i++){
            pointer = pointer.next;
            before = before.next;
        }
        before.next = pointer.next;


        return head;

    }
    public int length(ListNode head){
        if (head == null){
            return 0;
        }
        int counter = 1;
        ListNode pointer = head;
        while (pointer.next != null){
            counter += 1;
            pointer = pointer.next;
        }
        return counter;
    }
}