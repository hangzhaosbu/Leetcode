"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next
"""

class Solution:
    def insert(self, head: 'Optional[Node]', insertVal: int) -> 'Node':
        if not head:
            node = Node(insertVal)
            node.next = node
            return node
        
        
        def insert(node, insertVal):
            nxt = node.next
            newNode = Node(insertVal)
            
            node.next = newNode
            newNode.next = nxt
            
        curt = head
        
        while curt:
            
            if curt.val <= insertVal and curt.next.val >= insertVal:
                insert(curt, insertVal)
                return head
                
            elif curt.val > curt.next.val and (curt.next.val >= insertVal or insertVal >= curt.val):
                insert(curt, insertVal)
                return head
            
            elif curt.next == head:
                insert(curt, insertVal)
                return head
            
            curt = curt.next
        
        return head
            
            
            