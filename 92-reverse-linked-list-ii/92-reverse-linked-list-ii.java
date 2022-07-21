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
    
    private ListNode[] reverse(ListNode head)
    {
        ListNode prev = null, tail = head;
        
        while(head!=null)
        {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return new ListNode[]{prev, tail};
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right)
    {
        ListNode dummy = new ListNode(0), first = null, second = null, third = null, curr = dummy, prev = null;
        dummy.next = head;
        int count = 1;
        
        while(curr!=null)
        {
            prev = curr;
            curr = curr.next;
            count++;
            
            if(count == left+1)
            {
                second = curr;
                first = prev;
                prev.next = null;
            }
            
            if(count == right + 2)
            {
                third = curr;
                prev.next = null;
            }
        }
        
        ListNode[] l = reverse(second);
        if(l[0]!=null)
        {
            first.next = l[0];
        }
        
        if(l[1]!=null)
        {
            l[1].next = third;
        }
        
        
        return dummy.next;
    }
}