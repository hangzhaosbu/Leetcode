"""
本代码来自 CSON 官方视频课程，由 @CSON 提供
题目来源：http://leetcode.com
- CSON 致力于在 CS 领域内帮助中国人找到工作，让更多海内外国人受益
- 讲师：Edward Shi
- 官方网站：https://cspiration.com
- 版权归 CSON 所有，转发请注明出处
"""


# method 1
class _326_PowerofThree:
    def isPowerOfThree(self, n: int) -> bool:
        if n <= 0: return False
        while n % 3 == 0:
            n /= 3
        return n == 1


# method 2
class _326_PowerofThree:
    def isPowerOfThree(self, n: int) -> bool:
        if n <= 0: return False
        return round(math.log(n, 3), 9) == round(math.log(n, 3))
