/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* str2tree(string s) {
        if(s.length() == 0) return nullptr;
        
        int i = 0, n = s.length();
        
        while(i < n && s[i] != '(')
        {
            i++;
        }
        
        // cout << s.substr(0, i) << endl;
        
        if(i == n) return new TreeNode(stoi(s));
        TreeNode* root = new TreeNode(stoi(s.substr(0, i)));
        
        int balance = 0;
        int start = i;
        
        int j = i;
        
        while(j < n)
        {
            char c = s[j];
            if(c == '(') balance++;
            else if(c == ')') balance--;
            
            if(balance == 0)
            {
                if(start == i)
                {
                    root->left = str2tree(s.substr(start + 1, j - start - 1));
                    start = j + 1;
                }
                else
                {
                    root->right = str2tree(s.substr(start + 1, j - start - 1));
                }
            }
            
            j++;
        }
        
        return root;
    }
};