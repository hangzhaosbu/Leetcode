/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:
    string ans;
    int k = 0;
    // Encodes a tree to a single string.
    string serialize(TreeNode* root)
    {
        dfs(root);
        // cout << ans;
        return ans.substr(0, ans.length() - 1);
    }
    
    void dfs(TreeNode* root)
    {
        if(root == nullptr)
        {
            ans += "N,";
            return;
        }
        
        ans += to_string(root->val) + ",";
        dfs(root->left);
        dfs(root->right);
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        if(data[k] == 'N') 
        {
            k+=2;
            return nullptr;
        }
        
        int p = k + 1;
        
        while(p < data.size() && data[p] != ',') p++;
        
        TreeNode* curt = new TreeNode(stoi(data.substr(k, p - k)));
        k = p + 1;
        
        curt->left = deserialize(data);
        curt->right = deserialize(data);
        
        return curt;
        // return nullptr;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));