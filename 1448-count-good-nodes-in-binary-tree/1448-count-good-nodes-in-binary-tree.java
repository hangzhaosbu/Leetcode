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
class Pair<TreeNode, Integer>{
    TreeNode first;
    Integer second;
    
    public Pair(TreeNode first, Integer second)
    {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int goodNodes(TreeNode root)
    {
        int count = 1;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        
        queue.offer(new Pair<>(root, root.val));
        
        while(!queue.isEmpty())
        {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.first;
            int max = pair.second;
            
            if(node.left != null)
            {
                int new_max = Math.max(max, node.left.val);
                if(new_max <= node.left.val)
                {
                    count++;
                }
                queue.offer(new Pair<>(node.left, new_max));
            }
            
            if(node.right != null)
            {
                int new_max = Math.max(max, node.right.val);
                if(new_max <= node.right.val)
                {
                    count++;
                }
                queue.offer(new Pair<>(node.right, new_max));
            }
        }
        
        return count;
    }
}