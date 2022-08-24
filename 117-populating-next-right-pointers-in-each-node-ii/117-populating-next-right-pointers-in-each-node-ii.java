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
        if(root == null) return root;
        
        Node curr = root;
        Node head = null, prev = null;
        
        while(curr != null)
        {
            while(curr != null)
            {
                if(curr.left != null)
                {
                    if(head == null)
                    {
                        head = curr.left;
                        prev = curr.left;
                    }
                    else
                    {
                        prev.next = curr.left;
                        prev = prev.next;
                    }
                }
                
                if(curr.right != null)
                {
                    if(head == null)
                    {
                        head = curr.right;
                        prev = curr.right;
                    }
                    else
                    {
                        prev.next = curr.right;
                        prev = prev.next;
                    }
                }
                
                curr = curr.next;
            }
            
            curr = head;
            head = null;
            prev = null;
        }
        
        return root;
    }
}