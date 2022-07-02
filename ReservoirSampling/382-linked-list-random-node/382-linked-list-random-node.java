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

    ListNode node;
    public Solution(ListNode head) {
        node = head;
    }
    
    public int getRandom() {
        int x = 0;
        int count = 0;
        
        Random random = new Random();
        ListNode n = node;
        
        while(n != null)
        {
            count++;
            int rand = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE)%count;
            if(rand == 0)
            {
                x = n.val;
            }
            
            n = n.next;
        }
        
        return x;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */