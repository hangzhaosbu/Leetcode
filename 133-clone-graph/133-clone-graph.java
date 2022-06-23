/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node)
    {
        if(node == null) return null;
        
        HashMap<Node, Node> hashmap = new HashMap<>();
        HashSet<Node> hashset = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        hashset.add(node);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            for(int i = 0; i < size; ++i)
            {
                Node curt = queue.poll();
                hashmap.put(curt, new Node(curt.val));
                
                for(Node neighbor : curt.neighbors)
                {
                    if(!hashset.contains(neighbor))
                    {
                        queue.offer(neighbor);
                        hashset.add(neighbor);
                    }
                }
            }
        }
        
        hashset = new HashSet<>();
        queue = new LinkedList<>();
        queue.offer(node);
        hashset.add(node);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            for(int i = 0; i < size; ++i)
            {
                Node curt = queue.poll();
                
                for(Node neighbor : curt.neighbors)
                {
                    hashmap.get(curt).neighbors.add(hashmap.get(neighbor));
                    
                    if(!hashset.contains(neighbor))
                    {
                        queue.offer(neighbor);
                        hashset.add(neighbor);
                    }
                }
            }
        }
        return hashmap.get(node);
    }
}