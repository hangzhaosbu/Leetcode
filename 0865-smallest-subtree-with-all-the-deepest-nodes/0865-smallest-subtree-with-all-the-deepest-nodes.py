# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def subtreeWithAllDeepest(self, root: TreeNode) -> TreeNode:
        maxD = 0
        hashset = set()
        ans = None
        
        def dfs1(node, depth):
            nonlocal maxD
            if not node:
                return
            
            if node.left == None and node.right == None:
                maxD = max(maxD, depth)
                return 
            
            dfs1(node.left, depth + 1)
            dfs1(node.right, depth + 1)
                
        def dfs2(node, depth):
            if not node:
                return
            
            if node.left == None and node.right == None:
                if depth == maxD:
                    hashset.add(node.val)
                return 
            
            dfs2(node.left, depth + 1)
            dfs2(node.right, depth + 1)
            
        def dfs3(node):
            nonlocal ans
            
            if not node:
                return 0
            
            left = dfs3(node.left)
            right = dfs3(node.right)
            
            
            
            if node.val in hashset:
                if 1 + left + right == len(hashset) and ans == None:
                    ans = node
                return 1 + left + right
            else:
                if left + right == len(hashset) and ans == None:
                    ans = node
                return left + right
        
        dfs1(root, 1)
        dfs2(root, 1)
        dfs3(root)
        
        return ans
        
        