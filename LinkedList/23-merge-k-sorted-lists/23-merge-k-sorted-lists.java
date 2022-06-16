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
    private ListNode merge(ListNode list1, ListNode list2)
    {
        ListNode dummy = new ListNode(0);
        ListNode curt = dummy;
        
        while(list1 != null || list2 != null)
        {
            if(list1 != null && list2 != null)
            {
                if(list1.val < list2.val)
                {
                    curt.next = list1;
                    list1 = list1.next;
                }
                else
                {
                    curt.next = list2;
                    list2 = list2.next;
                }
            }
            else
            {
                if(list1 == null)
                {
                    curt.next = list2;
                    list2 = list2.next;
                }
                else
                {
                    curt.next = list1;
                    list1 = list1.next;
                }
            }
            
            curt = curt.next;
        }
        
        return dummy.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists)
    {
        while(lists.length > 1)
        {
            int N = lists.length, p = 0;
            ListNode[] new_lists = N % 2 == 0 ? new ListNode[N / 2] : new ListNode[N / 2 + 1];
            
            for(int i = 0; i < N; i+=2)
            {
                new_lists[p++] = (i + 1 < N) ? merge(lists[i], lists[i + 1]) : lists[i];
            }
            
            lists = new_lists;
        }
        
        return lists.length > 0 ? lists[0] : null;
    }
}