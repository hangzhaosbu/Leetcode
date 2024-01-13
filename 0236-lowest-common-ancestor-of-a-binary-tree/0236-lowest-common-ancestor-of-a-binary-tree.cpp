/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* ans;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        dfs(root, p, q);
        
        return ans;
    }
    
    int dfs(TreeNode* root, TreeNode* p, TreeNode* q)
    {
        if(root == nullptr) return 0;
        
        int left = dfs(root->left, p, q);
        int right = dfs(root->right, p, q);
        
        if((left + right == 2 || (left + right == 1 && (root == p || root == q))) && ans == nullptr)
        {
            ans = root;
        }
        
        if(root == p || root == q)
        {
            return 1 + left + right;
        }
        else
        {
            return left + right;
        }
    }
};