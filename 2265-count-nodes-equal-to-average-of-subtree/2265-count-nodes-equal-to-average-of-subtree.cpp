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
    int count = 0;
    
    int averageOfSubtree(TreeNode* root) {
        dfs(root);
        return count;
    }
    
    pair<int,int> dfs(TreeNode* root)
    {
        if(root == NULL) return {0, 0};
        
        pair<int,int> left = dfs(root->left);
        pair<int,int> right = dfs(root->right);
        
        if((left.first + right.first + root->val) / (left.second + right.second + 1) == root->val)
        {
            count++;
        }
        
        return {left.first + right.first + root->val, left.second + right.second + 1};
    }
};