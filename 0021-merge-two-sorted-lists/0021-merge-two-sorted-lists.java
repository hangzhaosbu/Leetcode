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

 // Time Complexity: O(N + M)
// Space Complexity: O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        
        while(list1 != null && list2 != null)
        {
            if(list1.val < list2.val)
            {
                cursor.next = list1;
                list1 = list1.next;
            }
            else
            {
                cursor.next = list2;
                list2 = list2.next;
            }
            cursor = cursor.next;
        }
        
        while(list1 != null)
        {
            cursor.next = list1;
            list1 = list1.next;
            cursor = cursor.next;
        }
        
        while(list2 != null)
        {
            cursor.next = list2;
            list2 = list2.next;
            cursor = cursor.next;
        }
        
        return dummy.next;
    }
}