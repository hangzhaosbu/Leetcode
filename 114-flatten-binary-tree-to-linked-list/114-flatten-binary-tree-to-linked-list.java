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
   
    public void flatten(TreeNode root) {
        
        // Handle the null scenario
        if (root == null) {
            return;
        }
        
        TreeNode node = root;
        
        while (node != null) {
            
            // If the node has a left child
            if (node.left != null) {
                
                // Find the rightmost node
                TreeNode rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                
                // rewire the connections
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            
            // move on to the right side of the tree
            node = node.right;
        }
    }
}