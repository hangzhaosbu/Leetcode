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
public class Pair<TreeNode, Integer>
{
    TreeNode node;
    Integer sum;
    
    public Pair(TreeNode node, Integer sum)
    {
        this.node = node;
        this.sum = sum;
    }
}

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        Pair<TreeNode, Integer> pair = dfs(root,root);
        if(pair.sum == 0)
        {
            return null;
        }
        return root;
    }
    
    
    private Pair<TreeNode, Integer> dfs(TreeNode root, TreeNode prev)
    {
        if(root == null)
        {
            return new Pair<>(null, 0);
        }
        
        Pair<TreeNode, Integer> left = dfs(root.left, root);
        Pair<TreeNode, Integer> right = dfs(root.right, root);
        if(left.sum == 0)
        {
            root.left = null;
        }
        else
        {
            root.left = left.node;
        }
        
        if(right.sum == 0)
        {
            root.right = null;
        }
        else
        {
            root.right = right.node;
        }
        
        return new Pair<>(root, left.sum + right.sum + root.val);
    }
}