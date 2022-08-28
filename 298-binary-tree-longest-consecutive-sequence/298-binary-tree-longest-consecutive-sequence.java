/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result = 0;
    
    public int longestConsecutive(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        
        dfs(root, 0, root.val);
        
        return result;
    }
    
    private void dfs(TreeNode node, int length, int prev)
    {
        if(node == null)
        {
            return;
        }
        
        if(node.val - 1 == prev)
        {
            length ++;
        }
        else
        {
            length = 1;
        }
        
        result = Math.max(result, length);
        
        dfs(node.left, length, node.val);
        dfs(node.right, length, node.val);
    }
}