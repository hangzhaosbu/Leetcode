# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        hashmap = {}
        ans = []
        
        queue = [(root, 0, 0)]
        
        while queue:
            size = len(queue)
            
            for _ in range(size):
                node, row, col = queue.pop(0)
                
                if col not in hashmap:
                    hashmap[col] = {}
                
                if row not in hashmap[col]:
                    hashmap[col][row] = []
                
                hashmap[col][row].append(node.val)
                
                
                if node.left:
                    queue.append((node.left, row + 1, col - 1))
                
                if node.right:
                    queue.append((node.right, row + 1, col + 1))
        
        for key in sorted(hashmap.keys()):
            curt = []
            for val in sorted(hashmap[key].keys()):
                curt.extend(sorted(hashmap[key][val]))
            
            ans.append(curt)
        
        return ans
            
        