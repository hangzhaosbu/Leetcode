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
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        if(root == null)
        {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> curt = new ArrayList<>();
            
            for(int i = 0; i < size; ++i)
            {
                curt.add(queue.peek().val);
                TreeNode node = queue.poll();
                
                if(node.left != null)
                {
                    queue.offer(node.left);
                }
                
                if(node.right != null)
                {
                    queue.offer(node.right);
                }
            }
            
            result.add(curt);
        }
        
        return result;
    }
}