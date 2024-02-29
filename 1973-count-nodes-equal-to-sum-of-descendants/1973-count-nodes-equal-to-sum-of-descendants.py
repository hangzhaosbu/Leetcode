# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def equalToDescendants(self, root: Optional[TreeNode]) -> int:
        r = 0
        m = {None: 0}
        s = [(root, False)]
        while s:
            n, v = s.pop()
            if v:
                x = m[n.left] + m[n.right]
                m[n] = x + n.val
                if x == n.val:
                    r += 1
            else:
                # left, right, root
                s.append((n, True))
                if n.right:
                    m[n.right] = n.val
                    s.append((n.right, False))
                if n.left:
                    m[n.left] = n.val
                    s.append((n.left, False))
        return r