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
    
    ListNode first = null;
    
    public boolean isPalindrome(ListNode head)
    {
        first = head;
        return recursion(head);
    }
    
    private boolean recursion(ListNode node)
    {
        if(node != null)
        {
            if(!recursion(node.next)) return false;
            if(node.val != first.val) return false;
            first = first.next;
        }
        
        return true;
    }
}