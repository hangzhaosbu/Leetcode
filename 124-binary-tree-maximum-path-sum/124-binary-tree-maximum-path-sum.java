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
    int result = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root)
    {
        dfs(root);
        return result;
    }
    
    private int dfs(TreeNode node)
    {
        /*
          2
        -1
        */
        if(node == null)
        {
            return 0;
        }
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        int curt = node.val;
        curt += left > 0 ? left : 0;
        curt += right > 0 ? right : 0;
        
        result = Math.max(curt, result);
        
        return (left > 0 || right > 0) ? Math.max(left, right) + node.val : node.val;
    }
}