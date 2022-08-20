/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
        {
            return root;
        }
        
        Node curt = root;
        Node next = curt.left;
        
        while(curt != null && next != null)
        {
            curt.left.next = curt.right;
            if(curt.next != null)
            {
                curt.right.next = curt.next.left;
                curt = curt.next;
            }
            else
            {
                curt = next;
                next = curt.left;
            }
        }
        
        return root;
    }
}