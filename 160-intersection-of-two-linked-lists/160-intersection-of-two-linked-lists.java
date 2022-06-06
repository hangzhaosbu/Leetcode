/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode pa = headA;
        ListNode pb = headB;
        
        int lengthA = 0;
        int lengthB = 0;
        
        while(pa != null){
            
            lengthA ++;
            pa = pa.next;
        }
        
        while(pb != null){
            
            lengthB ++;
            pb = pb.next;
        }
        
        int dif = Math.abs(lengthA - lengthB);
        
        while(dif != 0){
            
            if(lengthA >= lengthB){
                
                headA = headA.next;
            }
            else{
                
                headB = headB.next;
            }
            
            dif--;
        }
        
        while(headA != null && headB != null){
            
            if(headA == headB){
                
                return headA;
            }
            
            headA = headA.next;
            headB = headB.next;
            
        }
        
        return null;
        
    }
}