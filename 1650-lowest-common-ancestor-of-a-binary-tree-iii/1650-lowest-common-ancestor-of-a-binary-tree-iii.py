"""
# Definition for a Node.
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None
"""

class Solution:
    def lowestCommonAncestor(self, p: 'Node', q: 'Node') -> 'Node':
        
        
        def dfs(x, y):
            if x.val == y.val:
                return x
            
            if x.parent == None:
                return dfs(q, y.parent)
            elif y.parent == None:
                return dfs(x.parent, p)
            else:
                return dfs(x.parent, y.parent)
        
        return dfs(p, q)