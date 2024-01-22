# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    stack = []
    def __init__(self, root: Optional[TreeNode]):
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        res = self.stack[-1]
        self.stack.pop()
        if res.right:
            curt = res.right
            
            while curt:
                self.stack.append(curt)
                curt = curt.left
                
        return res.val

    def hasNext(self) -> bool:
        return len(self.stack)


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()