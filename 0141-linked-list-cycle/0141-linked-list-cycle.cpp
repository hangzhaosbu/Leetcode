/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool hasCycle(ListNode *head) {
        if(head == nullptr) return false;
        
        ListNode *slow = head;
        ListNode *fast = head;
        bool first = true;
        
        while(slow != fast || first)
        {
            slow = slow->next;
            
            if(fast != nullptr && fast->next != nullptr)
                fast = fast->next->next;
            else{
                return false;
            }
            if(first) first = false;
        }
        
        return true;
    }
};