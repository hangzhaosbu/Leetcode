/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Integer> hashset = new HashSet<>();
        
        while(p != null)
        {
            hashset.add(p.val);
            p = p.parent;
        }
        
        while(q != null)
        {
            if(hashset.contains(q.val))
            {
                return q;
            }
            q = q.parent;
        }
        
        return null;
    }
}