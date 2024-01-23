# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        neighbors = {}
        visited = set()
        
        def dfs(node):
            if not node:
                return
            
            if node.left:
                if node.left not in neighbors:
                    neighbors[node.left] = []
                neighbors[node.left].append(node)
                
                if node not in neighbors:
                    neighbors[node] = []
                
                neighbors[node].append(node.left)
                dfs(node.left)
            
            if node.right:
                if node.right not in neighbors:
                    neighbors[node.right] = []
                neighbors[node.right].append(node)
                
                if node not in neighbors:
                    neighbors[node] = []
                
                neighbors[node].append(node.right)
                dfs(node.right)
        
        dfs(root)
        
        ans = []
        queue = [(target, 0)]
        visited.add(target)
        
        while queue:
            node, depth = queue.pop(0)
            
            if depth == k:
                ans.append(node.val)
            
            if node not in neighbors or len(neighbors[node]) == 0:
                continue
            
            for neighbor in neighbors[node]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append((neighbor, depth + 1))
        
        return ans
        
        
        