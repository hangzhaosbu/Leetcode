"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        hashmap = {}
        visited = [False for _ in range(101)]
        
        queue = [node]
        hashmap[node.val] = Node(node.val, None)
        visited[node.val] = True
        
        while queue:
            
            curt = queue.pop(0)
            
            for neighbor in curt.neighbors:
                if not visited[neighbor.val]:
                    hashmap[neighbor.val] = Node(neighbor.val, None)
                    queue.append(neighbor)
                    visited[neighbor.val] = True
        
        visited = [False for _ in range(101)]
        queue = [node]
        visited[node.val] = True
        while queue:
            curt = queue.pop(0)
            
            for neighbor in curt.neighbors:
                if not visited[neighbor.val]:
                    
                    queue.append(neighbor)
                    visited[neighbor.val] = True
                
                if hashmap[neighbor.val] not in hashmap[curt.val].neighbors:
                    hashmap[curt.val].neighbors.append(hashmap[neighbor.val])
                if hashmap[curt.val] not in hashmap[neighbor.val].neighbors:
                    hashmap[neighbor.val].neighbors.append(hashmap[curt.val])
        return hashmap[node.val]