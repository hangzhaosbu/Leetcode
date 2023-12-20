/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* merge(ListNode* l1, ListNode* l2)
    {
        ListNode* head = new ListNode(0);
        ListNode* cursor = head;
        
        while(l1 != nullptr && l2 != nullptr)
        {
            // cout << l1 << " " << l2 << endl;
            
            if(l1->val < l2->val)
            {
                cursor->next = l1;
                l1 = l1->next;
            }
            else
            {
                cursor->next = l2;
                l2 = l2->next;
            }
            
            cursor = cursor->next;
        }
        
        while(l1 != nullptr)
        {
            cursor->next = l1;
            l1 = l1->next;
            cursor = cursor->next;
        }
        
        while(l2 != nullptr)
        {
            cursor->next = l2;
            l2 = l2->next;
            cursor = cursor->next;
        }
        
        return head->next;
    }
    
    ListNode* mergeKLists(vector<ListNode*>& lists)
    {
        if(lists.size() == 0) return nullptr;
        
        while(lists.size() > 1)
        {
            vector<ListNode*> cand;
            
            for(int i = 0; i < lists.size() - 1; i+=2)
            {
                cand.push_back(merge(lists[i], lists[i + 1]));
            }
            
            if(lists.size() % 2 == 1)
            {
                cand.push_back(lists[lists.size() - 1]);
            }
            
            lists = cand;
        }
        
        return lists[0];
    }
};