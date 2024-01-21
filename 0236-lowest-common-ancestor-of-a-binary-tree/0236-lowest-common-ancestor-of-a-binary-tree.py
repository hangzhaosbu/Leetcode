# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        ans = None
        
        
        def dfs(node):
            nonlocal ans
            
            if not node:
                return 0
            
            left = dfs(node.left)
            right = dfs(node.right)
            
            
            total = left + right
            if node == p or node == q:
                total += 1
            
            if total == 2 and ans == None:
                ans = node
            
            return total
        
        dfs(root)
        return ans