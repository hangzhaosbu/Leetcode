# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        ret = [-1000]
        
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
                
            ret[0] = max(ret[0], root.val, root.val + left, root.val + right, curt)
            return max(root.val, root.val + left, root.val + right)
        dfs(root)
        return ret[0]