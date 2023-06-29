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
    public void reorderList(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode po = reverse(second);
        head = merge(head,po);
    }
    public ListNode reverse(ListNode head){
        ListNode before = null;
        while (head != null){
            ListNode n = head.next;
            head.next = before;
            before = head;
            head = n;

        }
        return before;
    }
    public ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        while (list1 != null && list2 != null){
            cursor.next = list1;
            list1 = list1.next;
            cursor = cursor.next;
            
            cursor.next = list2;
            list2 = list2.next;
            cursor = cursor.next;
        }
        while(list1 != null)
        {
            cursor.next = list1;
            list1 = list1.next;
            cursor = cursor.next;
        }
        return dummy.next;
    }
}