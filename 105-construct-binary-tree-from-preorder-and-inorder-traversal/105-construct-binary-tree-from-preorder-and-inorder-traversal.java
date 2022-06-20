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
    
    private TreeNode BT(int left_p, int right_p, int left_i, int right_i, int[] preorder, int[] inorder)
    {
        if(left_p > right_p || left_i > right_i)
        {
            return null;
        }
        
        int index = 0;
        TreeNode node = new TreeNode(preorder[left_p]);
        
        for(int i = left_i; i <= right_i; ++i)
        {
            if(preorder[left_p] == inorder[i])
            {
                index = i;
                break;
            }
        }
        
        node.left = BT(left_p + 1, left_p + 1 + (index - left_i) - 1, left_i, index - 1, preorder, inorder);
        node.right = BT(left_p + 1 + (index - left_i), right_p, index + 1, right_i, preorder, inorder);
        
        return node;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        return BT(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }
}