# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.ret = -999999
        
        def dfs(root):
            if not root:
                return 0
            
            left = dfs(root.left)
            right = dfs(root.right)
            
            
            curt = root.val
            
            if left > 0:
                curt += left
            
            if right > 0:
                curt += right
                
            self.ret = max(self.ret, root.val, root.val + left, root.val + right, curt)
            return max(root.val, root.val + left, root.val + right)
        dfs(root)
        return self.ret