"""
本代码来自 CSON 官方视频课程，由 @CSON 提供
题目来源：http://leetcode.com
- CSON 致力于在 CS 领域内帮助中国人找到工作，让更多海内外国人受益
- 讲师：Edward Shi
- 官方网站：https://cspiration.com
- 版权归 CSON 所有，转发请注明出处
"""


class _306_AdditiveNumber:
    def isAdditiveNumber(self, num: str) -> bool:
        if num == None or len(num) < 3: return False
        for i in range(1, int(len(num) / 2) + 1):
            if num[0] == '0' and i > 1: return False
            first = int(num[:i])
            j = 1
            while len(num) - i - j >= max(i, j):
                if num[i] == '0' and j > 1: break
                second = int(num[i:i + j])
                if self.isValid(first, second, i + j, num):
                    return True
                j += 1
        return False

    def isValid(self, first: int, second: int, start: int, num: str) -> bool:
        if start == len(num): return True
        second = first + second
        first = second - first
        third = str(second)
        return num.startswith(third, start) and self.isValid(first, second, start + len(third), num)
