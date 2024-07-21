# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        ret = [0, 0]
        def dfs(node):
            if not node:
                return
            
            dfs(node.left)
            
            ret[0] += 1
            if ret[0] == k:
                ret[1] = node.val
                return
            
            dfs(node.right)
            
        dfs(root)
        
        return ret[1]