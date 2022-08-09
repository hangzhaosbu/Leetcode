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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> lst = new ArrayList<>();
        
        if(root == null){
            return lst;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        
        q.offer(root);
        cols.add(0);
        
        int max = 0;
        int min = 0;
        
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            int col = cols.poll();
            
            if(!map.containsKey(col)){
                map.put(col, new ArrayList<>());
            }
            
            map.get(col).add(cur.val);
            
            if(cur.left != null){
                q.offer(cur.left);
                cols.add(col - 1);
                
                min = Math.min(min, col - 1);
            }
            
            if(cur.right != null){
                q.offer(cur.right);
                
                cols.add(col + 1);
                
                max = Math.max(max, col + 1);
            }
        }
        
        for(int i = min; i <= max; i++){
            lst.add(map.get(i));
        }
        
        return lst;
    }
}