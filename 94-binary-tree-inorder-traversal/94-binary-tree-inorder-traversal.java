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
    List<Integer> result = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
        {
            return new ArrayList<>();
        }
        
        dfs(root);
        
        return result;
    }
    
    private void dfs(TreeNode node)
    {
        if(node == null)
        {
            return;
        }
        
        dfs(node.left);
        result.add(node.val);
        dfs(node.right);
    }
}