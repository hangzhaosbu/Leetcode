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
    public String tree2str(TreeNode root) {
        StringBuilder result = new StringBuilder();
        result.append(root.val);
        
        
        boolean left = false;
        if(root.left != null)
        {
            result.append("(" + tree2str(root.left) + ")");
            left = true;
        }
        
        if(root.right != null)
        {
            if(left == false)
            {
                result.append("()");
            }
            result.append("(" + tree2str(root.right) + ")");
        }
        
        
        return result.toString();
    }
}