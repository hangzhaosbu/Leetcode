"""
本代码来自 CSON 官方视频课程，由 @CSON 提供
题目来源：http://leetcode.com
- CSON 致力于在 CS 领域内帮助中国人找到工作，让更多海内外国人受益
- 讲师：Edward Shi
- 官方网站：https://cspiration.com
- 版权归 CSON 所有，转发请注明出处
"""


# method 1
class _342_PowerofFour:
    def isPowerOfFour(self, num: int) -> bool:
        if num > 1:
            while num % 4 == 0:
                num /= 4
        return num == 1


# method 2
class _342_PowerofFour:
    def isPowerOfFour(self, num: int) -> bool:
        if num <= 0: return False
        return math.log(num) / math.log(4) % 1 == 0
