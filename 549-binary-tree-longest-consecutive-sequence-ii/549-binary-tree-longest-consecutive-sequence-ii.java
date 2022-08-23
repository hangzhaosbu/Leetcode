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
        
        dfs(root);
        return result;
    }
    
    private int[] dfs(TreeNode node)
    {
        if(node == null){
            return new int[]{0, 0};
        }
        
        // 0: increasing length, 1: decreasing length
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        if(node.left != null && node.val + 1 == node.left.val)
        {
            left[0] ++;
        }
        else
        {
            left[0] = 1;
        }
        
        if(node.left != null && node.val - 1 == node.left.val)
        {
            left[1] ++;
        }
        else
        {
            left[1] = 1;
        }
        
        if(node.right != null && node.val + 1 == node.right.val)
        {
            right[0] ++;
        }
        else
        {
            right[0] = 1;
        }
        
        if(node.right != null && node.val - 1 == node.right.val)
        {
            right[1] ++;
        }
        else
        {
            right[1] = 1;
        }
        
        result = Math.max(result, Math.max(left[0] + right[1] - 1, left[1] + right[0] - 1));
        return new int[]{Math.max(left[0], right[0]), Math.max(left[1], right[1])};
    }
}