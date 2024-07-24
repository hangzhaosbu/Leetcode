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
        hashmap[node] = Node(node.val, None)
        visited[node.val] = True
        
        while queue:
            
            curt = queue.pop(0)
            
            for neighbor in curt.neighbors:
                if not visited[neighbor.val]:
                    hashmap[neighbor] = Node(neighbor.val, None)
                    queue.append(neighbor)
                    visited[neighbor.val] = True
                hashmap[curt].neighbors.append(hashmap[neighbor])

        return hashmap[node]