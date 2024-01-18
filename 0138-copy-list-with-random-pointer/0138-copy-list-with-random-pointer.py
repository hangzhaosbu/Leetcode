"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        
        
        curt = head
        hashmap = {}
        
        while curt:
            node = Node(curt.val)
            if curt.random:
                random = Node(curt.random.val)
                hashmap[curt.random] = random
            hashmap[curt] = node
            
            curt = curt.next
            
        curt = head
        
        while curt:
            
            copycurt = hashmap[curt]
            
            
            if curt.next:
                copynext = hashmap[curt.next]
                copycurt.next = copynext
            if curt.random:
                copyrandom = hashmap[curt.random]
                copycurt.random = copyrandom
            
            curt = curt.next
        
        return hashmap[head]