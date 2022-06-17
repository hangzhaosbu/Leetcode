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
    
    private boolean SameTree(TreeNode node1, TreeNode node2)
    {
        if(node1 == null && node2 == null)
        {
            return true;
        }
        else if((node1 != null && node2 == null) || (node1 == null && node2 != null))
        {
            return false;
        }
        return node1.val == node2.val && SameTree(node1.left, node2.left) && SameTree(node1.right, node2.right);
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot)
    {
        if(root == null && subRoot == null)
        {
            return true;
        }
        else if((root != null && subRoot == null) || (root == null && subRoot != null))
        {
            return false;
        }
        return SameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}