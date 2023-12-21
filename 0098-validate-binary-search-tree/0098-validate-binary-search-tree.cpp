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

typedef long long ll;
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        return dfs(root, INT64_MIN, INT64_MAX);
    }
    
    bool dfs(TreeNode* root, ll left, ll right)
    {
        if(root == nullptr) return true;
        
        return root->val > left && root->val < right && dfs(root->left, left, root->val) && dfs(root->right, root->val, right);
    }
};