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
    
    private ListNode reverseList(ListNode head)
    {
        ListNode prev = null, next = null;
        
        while(head != null)
        {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
    
    public void reorderList(ListNode head)
    {
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;
        
        second = reverseList(second);
        
        ListNode dummy = new ListNode(0);
        ListNode curt = dummy;
        
        int flag = 1;
        
        while(first != null || second != null)
        {
            if(first != null && flag == 1)
            {
                curt.next = first;
                first = first.next;
            }
            else if(second != null && flag == 0)
            {
                curt.next = second;
                second = second.next;
            }
            else
            {
                if(first != null)
                {
                    curt.next = first;
                    first = first.next;
                }
                else
                {
                    curt.next = second;
                    second = second.next;
                }
            }
            
            curt = curt.next;
            flag = 1 - flag;
        }
        
        head = dummy.next;
    }
}