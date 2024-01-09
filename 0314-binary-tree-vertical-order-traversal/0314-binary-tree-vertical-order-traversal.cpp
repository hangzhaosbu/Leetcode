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
    
    
    vector<vector<int>> verticalOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if(root == nullptr) return ans;
        
        queue<pair<TreeNode*,int>> q;
        
        unordered_map<int, vector<int>> map;
        
        int minPos = INT_MAX, maxPos = INT_MIN;
        
        q.push({root, 0});
        
        while(!q.empty())
        {
            pair<TreeNode*,int> curt = q.front();
            q.pop();
            
            TreeNode* node = curt.first;
            int pos = curt.second;
            
            minPos = min(minPos, pos);
            maxPos = max(maxPos, pos);
            
            map[pos].push_back(node->val);
            
            
            if(node->left) q.push({node->left, pos - 1});
            if(node->right) q.push({node->right, pos + 1});
            
        }
        
        
        for(int p = minPos; p <= maxPos; p++)
        {
            ans.push_back(map[p]);
        }
        
        return ans;
    }
};