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
    
    private boolean valid(long left, long right, TreeNode node)
    {
        if(node == null)
        {
            return true;
        }
        return node.val > left && node.val < right && valid(left, (long) node.val, node.left) && valid((long) node.val, right, node.right);
    }
    
    public boolean isValidBST(TreeNode root)
    {
        return valid(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }
}