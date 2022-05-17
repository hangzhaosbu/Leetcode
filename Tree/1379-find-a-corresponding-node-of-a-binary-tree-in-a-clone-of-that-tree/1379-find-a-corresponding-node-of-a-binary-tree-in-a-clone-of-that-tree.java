/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    TreeNode ans = null;
    
    public void dfs(TreeNode node, TreeNode target)
    {
        if(node == null || (node.left == null && node.right == null))
        {
            return;
        }
        
        if(node.left != null && node.left.val == target.val)
        {
            ans = node.left;
            return;
        }
        
        if(node.right != null && node.right.val == target.val)
        {
            ans = node.right;
            return;
        }
        
        dfs(node.left, target);
        dfs(node.right, target);
    }
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) 
    {
        TreeNode dummy = new TreeNode(0);
        dummy.left = cloned;
        
        dfs(dummy, target);
        
        return ans;
    }
}