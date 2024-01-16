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
        
        elif head.next == head:
            node = Node(insertVal)
            head.next = node
            node.next = head
            
            return head
        
        stored = head
        curt = head
        valid = False
        
        while curt:
            if curt.val <= insertVal and curt.next.val >= insertVal:
                nxt = curt.next
                node = Node(insertVal)
                curt.next = node
                node.next = nxt
                valid = True
            elif curt.val > curt.next.val and (insertVal <= curt.next.val or insertVal >= curt.val) :
                nxt = curt.next
                node = Node(insertVal)
                curt.next = node
                node.next = nxt
                valid = True
            else:
                curt = curt.next
            
                
            if curt.next == stored and valid == False:
                nxt = curt.next
                node = Node(insertVal)
                curt.next = node
                node.next = nxt
                valid = True
            if valid: break
                
        return head
        