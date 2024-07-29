# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        
        def recur(preorder_start, preorder_end, inorder_start, inorder_end):
            if preorder_start > preorder_end:
                return None
            
            node = TreeNode(preorder[preorder_start])
            
            root_idx = inorder_start
            
            while root_idx < inorder_end and inorder[root_idx] != preorder[preorder_start]:
                root_idx += 1
            
            left_len = root_idx - inorder_start
            right_len = inorder_end - root_idx
            
            left = recur(preorder_start + 1, preorder_start + 1 + left_len - 1, inorder_start, root_idx - 1)
            right = recur(preorder_start + 1 + left_len, preorder_start + 1 + left_len + right_len - 1, root_idx + 1, inorder_end)
            
            node.left = left
            node.right = right
            
            
            return node
        
        
        
        return recur(0, len(preorder) - 1, 0, len(inorder) - 1)