"""
本代码来自 CSON 官方视频课程，由 @CSON 提供
题目来源：http://leetcode.com
- CSON 致力于在 CS 领域内帮助中国人找到工作，让更多海内外国人受益
- 讲师：Edward Shi
- 官方网站：https://cspiration.com
- 版权归 CSON 所有，转发请注明出处
"""


class _312_BurstBalloons:
    def maxCoins(self, n: List[int]) -> int:
        nums = [0 for _ in range(len(n) + 2)]
        i = 1
        for num in n:
            nums[i] = num
            i += 1
        nums[0] = nums[len(nums) - 1] = 1
        dp = [[0 for _ in range(len(nums))] for _ in range(len(nums))]
        for length in range(2, len(nums)):
            for left in range(len(nums) - length):
                right = left + length
                for k in range(left + 1, right):
                    dp[left][right] = max(dp[left][right], \
                                          nums[left] * nums[k] * nums[right] + dp[left][k] + dp[k][right])
        return dp[0][len(nums) - 1]
