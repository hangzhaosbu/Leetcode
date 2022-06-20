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
        if(preorder.length == 0 || inorder.length == 0)
        {
            return null;
        }
        
        int index = 0;
        
        for(int i = 0; i < inorder.length; ++i)
        {
            if(inorder[i] == preorder[0])
            {
                index = i;
                break;
            }
        }
        
        int[] l_preorder = new int[index];
        int[] r_preorder = new int[inorder.length - index - 1];
        
        int[] l_inorder = new int[index];
        int[] r_inorder = new int[inorder.length - index - 1];
        
        int lp = 0, rp = 0, li = 0, ri = 0;
        
        for(int i = 0; i < inorder.length; ++i)
        {
            if(i < index)
            {
                l_inorder[li++] = inorder[i];
            }
            
            if(i > index)
            {
                r_inorder[ri++] = inorder[i];
            }
        }
        
        for(int i = 1; i < preorder.length; ++i)
        {
            if(i < 1 + index)
            {
                l_preorder[lp++] = preorder[i];
            }
            
            if(i >= 1 + index)
            {
                r_preorder[rp++] = preorder[i];
            }
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(l_preorder, l_inorder);
        root.right = buildTree(r_preorder, r_inorder);
        
        return root;
    }
}