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
    
    private int result = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) 
    {
        maxDown(root);
        return result;
    }
    
    private int maxDown(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }
        
        int left = maxDown(node.left);
        int right = maxDown(node.right);
        
        int curt_val = node.val;
        curt_val += left >= 0 ? left : 0;
        curt_val += right >= 0 ? right : 0;
        
        result = Math.max(result, curt_val);
        return left < 0 && right < 0 ? node.val : node.val + Math.max(left, right);
    }
}