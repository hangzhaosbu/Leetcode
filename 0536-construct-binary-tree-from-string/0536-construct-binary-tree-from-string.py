# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def str2tree(self, s: str) -> Optional[TreeNode]:
        if len(s) == 0 or s == "":
            return None
        
        i = 0
        
        while i < len(s) and s[i] != '(':
            i+=1
        
        if i == len(s):
            return TreeNode(int(s))
        
        root = TreeNode(int(s[:i]))
        
        balance = 0
        start = i + 1
        
        for j in range(i, len(s)):
            
            if s[j] == '(':
                balance+=1
            elif s[j] == ')':
                balance-=1
                
            
            if balance == 0 and start == i + 1:
                root.left = self.str2tree(s[start:j])
                start = j + 1
            elif balance == 0:
                root.right = self.str2tree(s[start+1:j])
        
        
        return root