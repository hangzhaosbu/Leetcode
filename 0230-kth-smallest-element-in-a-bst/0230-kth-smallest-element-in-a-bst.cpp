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
    int K = 0;
    int ans = 0;
    
    int kthSmallest(TreeNode* root, int k)
    {
        dfs(root, k);
        return ans;
    }
    
    void dfs(TreeNode* root, int k)
    {
        if(root == nullptr) return;
        
        dfs(root->left, k);
        
        K++;
        
        if(K == k)
        {
            ans = root->val;
        }
        dfs(root->right, k);
    }
};