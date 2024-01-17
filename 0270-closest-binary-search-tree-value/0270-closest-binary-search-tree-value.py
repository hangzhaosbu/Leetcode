# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def closestValue(self, root: Optional[TreeNode], target: float) -> int:
        ans = float("inf")
        maxint = float("inf")
        
        def dfs(root, target):
            nonlocal ans, maxint
            
            if not root:
                return
            
            if abs(root.val - target) < maxint or (abs(root.val - target) == maxint and root.val < ans):
                ans = root.val
                maxint = abs(root.val - target)
                
            if root.val > target:
                dfs(root.left, target)
            else:
                dfs(root.right, target)
        
        dfs(root, target)
        
        return ans