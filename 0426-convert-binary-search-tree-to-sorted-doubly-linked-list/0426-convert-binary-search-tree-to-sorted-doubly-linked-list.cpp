/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;

    Node() {}

    Node(int _val) {
        val = _val;
        left = NULL;
        right = NULL;
    }

    Node(int _val, Node* _left, Node* _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
public:
    Node* last = nullptr;
    Node* first = nullptr;
    
    Node* treeToDoublyList(Node* root) {
        if(root == nullptr) return nullptr;
        
        help(root);
        
        first->left = last;
        last->right = first;
        
        return first;
    }
    
    void help(Node* root)
    {
        if(root == nullptr) return;
        
        help(root->left);
        
        if(last == nullptr) first = root;
        
        if(last != nullptr)
        {
            last->right = root;
            root->left = last;
        }
        
        last = root;
        
        help(root->right);
        
    }
};