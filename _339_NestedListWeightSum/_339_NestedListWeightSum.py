"""
本代码来自 CSON 官方视频课程，由 @CSON 提供
题目来源：http://leetcode.com
- CSON 致力于在 CS 领域内帮助中国人找到工作，让更多海内外国人受益
- 讲师：Edward Shi
- 官方网站：https://cspiration.com
- 版权归 CSON 所有，转发请注明出处
"""


# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
# class NestedInteger:
#    def __init__(self, value=None):
#        """
#        If value is not specified, initializes an empty list.
#        Otherwise initializes a single integer equal to value.
#        """
#
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def add(self, elem):
#        """
#        Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
#        :rtype void
#        """
#
#    def setInteger(self, value):
#        """
#        Set this NestedInteger to hold a single integer equal to value.
#        :rtype void
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

# DFS
class _339_NestedListWeightSum:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        if nestedList == None: return 0
        return self.helper(nestedList, 1)

    def helper(self, nestedList: List[NestedInteger], depth: int) -> int:
        res = 0
        for nest in nestedList:
            if nest.isInteger():
                res += nest.getInteger() * depth
            else:
                res += self.helper(nest.getList(), depth + 1)
        return res


# BFS
class _339_NestedListWeightSum:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        if nestedList == None: return 0
        depth = 1
        res = 0
        queue = nestedList
        while queue:
            size = len(queue)
            for i in range(size):
                nest = queue.pop(0)
                if nest.isInteger():
                    res += nest.getInteger() * depth
                else:
                    queue += nest.getList()
            depth += 1
        return res


# Optimized-BFS
class _339_NestedListWeightSum:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        if nestedList == None: return 0
        depth = 1
        res = 0
        while len(nestedList) != 0:
            nextList = []
            for nest in nestedList:
                if nest.isInteger():
                    res += nest.getInteger() * depth
                else:
                    nextList += nest.getList()
            depth += 1
            nestedList = nextList
        return res
