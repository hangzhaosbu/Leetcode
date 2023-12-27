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
    int ans = -1001;
    int maxPathSum(TreeNode* root)
    {
        dfs(root);
        return ans;
    }
    
    int dfs(TreeNode* root)
    {
        if(root == nullptr) return 0;
        
        int left = dfs(root->left);
        int right = dfs(root->right);
        
        int curt = root->val;
        
        if(left > 0) curt += left;
        if(right > 0) curt += right;
        
        ans = max(ans, curt);
        
        return max(root->val, max(root->val + left, root->val + right));
    }
};