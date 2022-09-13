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
    
    public int goodNodes(TreeNode root)
    {
        dfs(root, root.val);
        
        return result;
    }
    
    private void dfs(TreeNode node, int max_sofar)
    {
        
        if(node.val >= max_sofar)
        {
            result++;
        }
        
        if(node.left != null)
            dfs(node.left, Math.max(max_sofar, node.left.val));
        
        if(node.right != null)
            dfs(node.right, Math.max(max_sofar, node.right.val));
    }
}