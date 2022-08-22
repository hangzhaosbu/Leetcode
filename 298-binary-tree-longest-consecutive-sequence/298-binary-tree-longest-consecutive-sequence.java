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
        if(node == null)
        {
            return new int[]{0, Integer.MAX_VALUE};
        }

        // 0: length, 1: prev node val
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        
        if(node.val + 1 == left[1])
        {
            left[0]++;
        }
        else
        {
            left[0] = 1;
        }
        
        if(node.val + 1 == right[1])
        {
            right[0]++;
        }
        else
        {
            right[0] = 1;
        }
        
        result = Math.max(result, Math.max(left[0], right[0]));
        return new int[]{Math.max(left[0], right[0]), node.val};
    }
}