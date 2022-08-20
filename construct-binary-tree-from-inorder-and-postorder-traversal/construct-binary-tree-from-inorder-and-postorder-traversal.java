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
    
    private TreeNode recursion(int inorder_left, int inorder_right, int[] inorder, int postorder_left, int postorder_right, int[] postorder)
    {
        if(inorder_left > inorder_right || postorder_left > postorder_right)
        {
            return null;
        }
        
        int node_val = postorder[postorder_right];
        int node_index = inorder_left;
        
        while(inorder[node_index] != node_val)
        {
            node_index++;
        }
        
        int left_length = node_index - inorder_left;
        int right_length = inorder_right - node_index;
        
        TreeNode node = new TreeNode(node_val);
        
        
        TreeNode left = recursion(inorder_left, node_index - 1, inorder, postorder_right - right_length - left_length, postorder_right - right_length - 1, postorder);
        TreeNode right = recursion(node_index + 1, inorder_right, inorder, postorder_right - right_length,  postorder_right - 1, postorder);
        
        node.left = left;
        node.right = right;
        
        return node;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        return recursion(0, inorder.length - 1, inorder, 0, postorder.length - 1, postorder);
    }
}