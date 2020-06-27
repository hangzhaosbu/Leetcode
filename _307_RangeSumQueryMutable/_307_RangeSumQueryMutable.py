"""
本代码来自 CSON 官方视频课程，由 @CSON 提供
题目来源：http://leetcode.com
- CSON 致力于在 CS 领域内帮助中国人找到工作，让更多海内外国人受益
- 讲师：Edward Shi
- 官方网站：https://cspiration.com
- 版权归 CSON 所有，转发请注明出处
"""


# method 1
class _307_RangeSumQueryMutable:
    nums = None
    tree = None
    n = 0

    def __init__(self, nums: List[int]):
        self.n = len(nums)
        self.tree = [0 for _ in range(self.n + 1)]
        self.nums = [0 for _ in range(self.n)]
        for i in range(self.n):
            self.update(i, nums[i])

    def update(self, i: int, val: int) -> None:
        if self.n == 0: return
        diff = val - self.nums[i]
        self.nums[i] = val
        j = i + 1
        while j <= self.n:
            self.tree[j] += diff
            j += (j & -j)

    def sumRange(self, i: int, j: int) -> int:
        return self.getSum(j + 1) - self.getSum(i)

    def getSum(self, i: int) -> int:
        total = 0
        while i > 0:
            total += self.tree[i]
            i -= (i & -i)
        return total


# method 2
class _307_RangeSumQueryMutable:
    nums = None
    tree = None

    def __init__(self, nums: List[int]):
        self.nums = nums
        self.tree = [0 for _ in range(len(nums) + 1)]
        for i in range(len(self.tree)):
            total = 0
            lowbit = i & (-i)
            for j in range(i, i - lowbit, -1):
                total += nums[j - 1]
            self.tree[i] = total

    def update(self, i: int, val: int) -> None:
        diff = val - self.nums[i]
        self.nums[i] = val
        i += 1
        while i < len(self.tree):
            self.tree[i] += diff
            i += (i & -i)

    def sumRange(self, i: int, j: int) -> int:
        return self.getSum(j + 1) - self.getSum(i)

    def getSum(self, i: int) -> int:
        total = 0
        while i > 0:
            total += self.tree[i]
            i -= (i & -i)
        return total
