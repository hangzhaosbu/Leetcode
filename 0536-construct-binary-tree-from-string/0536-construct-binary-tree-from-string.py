# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def str2tree(self, s: str) -> Optional[TreeNode]:
        if not s:
            return None
        i = 0
        n = len(s)
        
        while i < n and s[i] != '(':
            i += 1
        
        if i == n:
            return TreeNode(int(s))
        
        node = TreeNode(int(s[:i]))
        
        j = i
        balance = 0
        start = i
        
        while j < n:
            if s[j] == '(':
                balance += 1
            elif s[j] == ')':
                balance -= 1
            
            
            if balance == 0 and start == i:
                node.left = self.str2tree(s[start + 1:j])
                start = j + 1
                
            elif balance == 0:
                node.right = self.str2tree(s[start + 1:j])
            j += 1
        return node
            
        