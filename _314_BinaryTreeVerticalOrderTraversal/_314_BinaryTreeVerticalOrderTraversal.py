"""
本代码来自 CSON 官方视频课程，由 @CSON 提供
题目来源：http://leetcode.com
- CSON 致力于在 CS 领域内帮助中国人找到工作，让更多海内外国人受益
- 讲师：Edward Shi
- 官方网站：https://cspiration.com
- 版权归 CSON 所有，转发请注明出处
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    low = 0
    high = 0

    def verticalOrder(self, root: TreeNode) -> List[List[int]]:
        result = []
        if root == None: return result
        self.helper(root, 0)
        result = [[] for _ in range(self.low, self.high + 1)]
        queue = []
        index = []
        index.append(-self.low)
        queue.append(root)
        while len(queue) != 0:
            cur = queue.pop(0)
            idx = index.pop(0)
            result[idx].append(cur.val)
            if cur.left != None:
                queue.append(cur.left)
                index.append(idx - 1)
            if cur.right != None:
                queue.append(cur.right)
                index.append(idx + 1)
        return result

    def helper(self, root: TreeNode, idx: int) -> None:
        if root == None: return
        self.low = min(self.low, idx)
        self.high = max(self.high, idx)
        self.helper(root.left, idx - 1)
        self.helper(root.right, idx + 1)
