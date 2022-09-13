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
    
    public int diameterOfBinaryTree(TreeNode root)
    {
        dfs(root);
        
        return result - 1;
    }
    
    private int dfs(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        result = Math.max(result, left + right + 1);
        
        return Math.max(left, right) + 1;
    }
}