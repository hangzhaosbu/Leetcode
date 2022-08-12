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
    
    boolean result = true;
    
    private int dfs(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        if(left - right > 1 || right - left > 1)
        {
            result = false;
        }
        
        int height = Math.max(left, right) + 1;
        return height;
        
    }
    
    public boolean isBalanced(TreeNode root)
    {
        dfs(root);
        return result;
    }
}