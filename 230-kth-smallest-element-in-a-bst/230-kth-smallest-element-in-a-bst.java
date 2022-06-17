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
    private int count = 0;
    private int result = 0;
    
    private void dfs(TreeNode node, int k)
    {
        if(node == null)
        {
            return;
        }
        
        dfs(node.left, k);
        if(++count == k)
        {
            result = node.val;
        }
        dfs(node.right, k);
    }
    
    public int kthSmallest(TreeNode root, int k)
    {
        dfs(root, k);
        return result;
    }
}