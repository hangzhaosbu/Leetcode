# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        """
        3
      1   4
     0 2 2
        
        
        """
        memo = dict()
        ans = []
        q = [(root, 0, 0)]
        
        while q:
            node, row, col = q.pop(0)
            
            if col not in memo:
                memo[col] = {}
            
            if row not in memo[col]:
                memo[col][row] = []
            
            memo[col][row].append(node.val)
            
            if node.left:
                q.append((node.left, row + 1, col - 1))
            
            if node.right:
                q.append((node.right, row + 1, col + 1))
        
        
        for col in sorted(memo.keys()):
            curt = []
            for row in memo[col]:
                curt.extend(sorted(memo[col][row]))
            ans.append(curt)
        
        return ans
        