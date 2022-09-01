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
    public Node connect(Node root)
    {
        if(root == null) return null;
        
        Node curt = root;
        Node head = null, prev = null;
        
        while(curt != null)
        {
            while(curt != null)
            {
                if(curt.left != null)
                {
                    if(head == null)
                    {
                        head = curt.left;
                        prev = head;
                    }
                    else
                    {
                        prev.next = curt.left;
                        prev = prev.next;
                    }
                }
                
                if(curt.right != null)
                {
                    if(head == null)
                    {
                        head = curt.right;
                        prev = head;
                    }
                    else
                    {
                        prev.next = curt.right;
                        prev = prev.next;
                    }
                }
                
                curt = curt.next;
            }
            
            curt = head;
            head = null;
            prev = null;
        }
        
        return root;
    }
}