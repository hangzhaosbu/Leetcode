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


 //  Time Complexity: O(N)
//   Space Complexity: O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        
        while(head != null)
        {
            ListNode next = head.next; // information will get lost if dont store
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}