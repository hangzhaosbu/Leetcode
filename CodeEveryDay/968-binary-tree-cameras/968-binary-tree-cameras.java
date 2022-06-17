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
    final static int NO_CAMERA = 0;
    final static int HAS_CAMERA = 1;
    final static int NO_NEED = 2;
    int ans = 0;
    
    private int dfs(TreeNode node)
    {
        if(node == null)
        {
            return NO_NEED;
        }
        
        int left = dfs(node.left), right = dfs(node.right);
        
        if(left == NO_CAMERA || right == NO_CAMERA)
        {
            ans++;
            return HAS_CAMERA;
        }
        else if(left == HAS_CAMERA || right == HAS_CAMERA)
        {
            return NO_NEED;
        }
        else
        {
            return NO_CAMERA;
        }
    }
    
    public int minCameraCover(TreeNode root)
    {
        if(dfs(root) == NO_CAMERA) ans++;
        return ans;
    }
}