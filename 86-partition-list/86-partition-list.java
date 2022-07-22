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
    public ListNode partition(ListNode head, int x)
    {
        List<Integer> small = new ArrayList<>(), large = new ArrayList<>();
        int p1 = 0, p2 = 0;
        
        while(head!=null)
        {
            if(head.val < x)
            {
                small.add(head.val);
            }
            else
            {
                large.add(head.val);
            }
            head = head.next;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while(p1 < small.size() || p2 < large.size())
        {
            curr.next = p1 < small.size() ? new ListNode(small.get(p1++)) : new ListNode(large.get(p2++));
            curr = curr.next;
        }
        
        return dummy.next;
    }
}