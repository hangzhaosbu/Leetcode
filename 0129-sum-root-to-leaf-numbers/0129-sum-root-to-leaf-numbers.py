# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        ans = 0
        
        
        def dfs(node, total):
            nonlocal ans
            if not node:
                return
            
            if node.left == None and node.right == None:
                total=total*10 + node.val
                ans += total
                return
            
            dfs(node.left, total*10+node.val)
            dfs(node.right, total*10+node.val)
        
        dfs(root, 0)
        
        return ans