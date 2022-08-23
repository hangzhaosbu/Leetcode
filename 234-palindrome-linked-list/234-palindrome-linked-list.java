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
        ListNode prev = null, next = null;
        ListNode curt = head;
        int count = 0;
        
        while(curt != null)
        {
            curt = curt.next;
            count ++;
        }
        
        count = count / 2;
        
        int len = count;
        
        curt = head;
        
        while(count > 0)
        {
            curt = curt.next;
            count--;
        }
        
        while(curt != null)
        {
            next = curt.next;
            curt.next = prev;
            prev = curt;
            curt = next;
        }
        
        while(len > 0)
        {
            if(prev.val == head.val)
            {
                prev = prev.next;
                head = head.next;
            }
            else{
                return false;
            }
            len --;
        }
        
        return true;
    }
}