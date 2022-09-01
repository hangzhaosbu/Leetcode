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
    public boolean isPalindrome(ListNode head)
    {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = null;
        int count = 0;
        while(slow != null)
        {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
            count++;
        }
        
        while(count > 0)
        {
            count--;
            if(head.val == prev.val)
            {
                head = head.next;
                prev = prev.next;
            }
            else
            {
                return false;
            }
        }
        
        return true;
        
        
    }
}