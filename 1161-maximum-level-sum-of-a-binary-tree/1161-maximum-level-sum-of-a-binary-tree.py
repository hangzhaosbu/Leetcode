# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        hashmap = {}
        
        
        def dfs(node, depth):
            if not node:
                return 
            
            hashmap[depth] = hashmap.get(depth, 0) + node.val
            
            dfs(node.left, depth + 1)
            dfs(node.right, depth + 1)
        
        dfs(root, 1)
        
        maxSum = float("-inf")
        maxLevel = 0
        
        # print(hashmap)
        
        for key, val in hashmap.items():
            if val > maxSum:
                maxSum = val
                maxLevel = key
        
        return maxLevel