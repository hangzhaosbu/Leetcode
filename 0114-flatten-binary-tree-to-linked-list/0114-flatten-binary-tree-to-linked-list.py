# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        
        def dfs(node):
            if not node:
                return None, None
            
            lF, lL = dfs(node.left)
            rF, rL = dfs(node.right)
            
            if lF and lL:
                
                node.left = None
                node.right = lF
                lL.right = rF
            
            last = rL or lL or node
            
            return  node, last
        
        dfs(root)