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
    
    public List<Integer> rightSideView(TreeNode root)
    {
        dfs(root, 0);
        
        return result;
    }
    
    private void dfs(TreeNode node, int height)
    {
        
        /*
              1
             2 3
            4
        */
        if(node == null)
        {
            return;
        }
        
        if(height == result.size())
        {
            result.add(node.val);
        }
        
        if(node.right != null)
        {
            dfs(node.right, height + 1);
        }
        
        if(node.left != null)
        {
            dfs(node.left, height + 1);
        }
    }
}