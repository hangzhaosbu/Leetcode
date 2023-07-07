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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        while(lists.length > 1)
        {
            ListNode[] newLists = new ListNode[(lists.length + 1)/2];
            int p = 0;
            for(int i = 0; i < lists.length; i+=2)
            {
                if(i == lists.length - 1)
                    newLists[p++] = lists[i];
                else
                    newLists[p++] = merge(lists[i], lists[i + 1]);
            }
            
            lists = newLists;
        }
        
        return lists[0];
    }
    public ListNode merge(ListNode list1, ListNode list2){
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        ListNode dummy = new ListNode(-1);
        ListNode cursor = dummy;

        while (pointer1 != null && pointer2 != null){
            if (pointer1.val < pointer2.val){
                cursor.next = pointer1;
                pointer1 = pointer1.next;
                cursor = cursor.next;
            }
            else{
                cursor.next = pointer2;
                pointer2 = pointer2.next;
                cursor = cursor.next;
            }
        }
        while (pointer1 != null){
            cursor.next = pointer1;
            pointer1 = pointer1.next;
            cursor = cursor.next;
        }
        while (pointer2 != null){
            cursor.next = pointer2;
            pointer2 = pointer2.next;
            cursor = cursor.next;
        }
        return dummy.next;
    }
}