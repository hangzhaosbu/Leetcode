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
    
    private TreeNode BT(int p_left, int p_right, int i_left, int i_right, int[] preorder, int[] inorder)
    {
        if(p_left > p_right || i_left > i_right)
        {
            return null;
        }
        
        int index = 0;
        
        for(int i = i_left; i <= i_right; ++i)
        {
            if(inorder[i] == preorder[p_left])
            {
                index = i;
                break;
            }
        }
        
        TreeNode root = new TreeNode(preorder[p_left]);
        root.left = BT(p_left + 1, p_left + 1 + (index - i_left) - 1, i_left, index - 1, preorder, inorder);
        root.right = BT(p_left + 1 + (index - i_left), p_right, index + 1, i_right, preorder, inorder);
            
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0)
        {
            return null;
        }
        return BT(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }
}