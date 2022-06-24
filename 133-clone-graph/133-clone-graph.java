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
    
    HashMap<Node, Node> hashmap = new HashMap<>();
    public Node cloneGraph(Node node)
    {
        if(node == null || hashmap.containsKey(node))
        {
            return node == null ? null : hashmap.get(node);
        }
        
        Node new_node = new Node(node.val);
        hashmap.put(node, new_node);
        
        for(Node neighbor : node.neighbors)
        {
            hashmap.get(node).neighbors.add(cloneGraph(neighbor));
        }
        
        return new_node;
    }
}