/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* parent;
};
*/

class Solution {
public:
    Node* lowestCommonAncestor(Node* p, Node * q) {
        Node* temp_p = p;
        Node* temp_q = q;
        
        
        while(temp_p != temp_q)
        {
            if(!temp_p) temp_p = q;
            else temp_p = temp_p->parent;
            
            if(!temp_q) temp_q = p;
            else temp_q = temp_q->parent;
        }
        
        return temp_p;
    }
};