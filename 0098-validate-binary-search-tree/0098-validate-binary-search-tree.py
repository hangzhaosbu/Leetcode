# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def valid(root, left, right):
            if not root:
                return True
            return root.val > left and root.val < right and valid(root.left, left, root.val) and valid(root.right, root.val, right)
        
        return valid(root, -10000000000, 10000000000)
        