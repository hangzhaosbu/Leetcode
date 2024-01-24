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
        else:
            
            curt = head
            
            while curt:
                if curt.val <= insertVal and curt.next.val >= insertVal:
                    node = Node(insertVal)
                    nxt = curt.next
                    curt.next = node
                    node.next = nxt
                    break
                elif curt.val > curt.next.val and (insertVal >= curt.val or insertVal <= curt.next.val):
                    node = Node(insertVal)
                    nxt = curt.next
                    curt.next = node
                    node.next = nxt
                    break
                elif curt.next == head:
                    node = Node(insertVal)
                    nxt = curt.next
                    curt.next = node
                    node.next = nxt
                    break
                
                curt = curt.next
            
            return head