/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head, slow = dummy;
        
        while(fast != null && fast.next != null && fast != slow)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow == fast;
    }
}