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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //1.create a queue
        //2.add root to the queue
        //3.do while loop
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
            
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++)
            {
                TreeNode node = q.poll();
                temp.add(node.val);
                
                if(node.left != null)
                {
                    q.offer(node.left);
                }
                
                if(node.right != null)
                {
                    q.offer(node.right);
                }
            }
            
            result.add(temp);
        }
        
        return result;
    }
}