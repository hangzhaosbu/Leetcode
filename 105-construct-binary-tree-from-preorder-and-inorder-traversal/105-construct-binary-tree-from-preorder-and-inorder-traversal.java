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
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        return recursion(0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder);
    }
    
    private TreeNode recursion(int preorder_left, int preorder_right, int[] preorder, int inorder_left, int inorder_right, int[] inorder)
    {
        if(preorder_left > preorder_right || inorder_left > inorder_right)
        {
            return null;
        }
        
        int node_val = preorder[preorder_left];
        TreeNode node = new TreeNode(node_val);
        
        int node_index = inorder_left;
        while(inorder[node_index] != node_val)
        {
            node_index++;
        }
        
        int left_length = node_index - inorder_left;
        int right_length = inorder_right - node_index;
        
        TreeNode left = recursion(preorder_left + 1, preorder_left + left_length, preorder, inorder_left, node_index - 1, inorder);
        TreeNode right = recursion(preorder_left + left_length + 1, preorder_left + left_length + right_length, preorder, node_index + 1, inorder_right, inorder);
        
        node.left = left;
        node.right = right;
        
        return node;
    }
}