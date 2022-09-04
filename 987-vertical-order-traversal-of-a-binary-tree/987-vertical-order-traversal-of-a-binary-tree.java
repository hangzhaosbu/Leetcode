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
    Integer pos;
    Integer depth;
    
    public Pair(TreeNode node, Integer pos, Integer depth)
    {
        this.node = node;
        this.pos = pos;
        this.depth = depth;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        HashMap<Integer, HashMap<Integer, List<Integer>>> hashmap = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        Integer max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        Integer max_depth = 0;
        
        queue.offer(new Pair<>(root, 0, 0));
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            for(int i = 0; i < size; ++i)
            {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.node;
                Integer pos = pair.pos;
                Integer depth = pair.depth;
                
                max = Math.max(max, pos);
                min = Math.min(min, pos);
                max_depth = Math.max(max_depth, depth);

                if(!hashmap.containsKey(pos))
                {
                    hashmap.put(pos, new HashMap<>());
                }
                
                if(!hashmap.get(pos).containsKey(depth))
                {
                    hashmap.get(pos).put(depth, new ArrayList<>());
                }

                hashmap.get(pos).get(depth).add(node.val);
                
                if(node.left != null)
                {
                    queue.offer(new Pair<>(node.left, pos - 1, depth + 1));
                }
                
                if(node.right != null)
                {
                    queue.offer(new Pair<>(node.right, pos + 1, depth + 1));
                }
            }
            
        }
        
        
        for(int i = min; i <= max; ++i)
        {
            List<Integer> curt = new ArrayList<>();
            for(int j = 0; j <= max_depth; ++j)
            {
                if(hashmap.get(i).get(j) != null)
                {
                    List<Integer> toAdd = hashmap.get(i).get(j);
                    Collections.sort(toAdd);
                    
                    for(Integer item : toAdd)
                    {
                        curt.add(item);
                    }
                }
            }
            result.add(curt);
        }
        
        return result;
    }
}