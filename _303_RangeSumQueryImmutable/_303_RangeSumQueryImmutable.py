"""
本代码来自 CSON 官方视频课程，由 @CSON 提供
题目来源：http://leetcode.com
- CSON 致力于在 CS 领域内帮助中国人找到工作，让更多海内外国人受益
- 讲师：Edward Shi
- 官方网站：https://cspiration.com
- 版权归 CSON 所有，转发请注明出处
"""


class _303_RangeSumQueryImmutable:
    sum = []

    def __init__(self, nums: List[int]):
        self.sum = [0 for _ in range(len(nums) + 1)]
        for i, num in enumerate(nums):
            self.sum[i + 1] = self.sum[i] + num

    def sumRange(self, i: int, j: int) -> int:
        return self.sum[j + 1] - self.sum[i]
