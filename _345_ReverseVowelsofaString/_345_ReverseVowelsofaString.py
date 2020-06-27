"""
本代码来自 CSON 官方视频课程，由 @CSON 提供
题目来源：http://leetcode.com
- CSON 致力于在 CS 领域内帮助中国人找到工作，让更多海内外国人受益
- 讲师：Edward Shi
- 官方网站：https://cspiration.com
- 版权归 CSON 所有，转发请注明出处
"""


class _345_ReverseVowelsofaString:
    def reverseVowels(self, s: str) -> str:
        if s == None or len(s) == 0: return s
        vowels = "aeiouAEIOU"
        string = list(s)
        left = 0
        right = len(string) - 1
        while left < right:
            while left < right and not string[left] in vowels:
                left += 1
            while left < right and not string[right] in vowels:
                right -= 1
            string[left], string[right] = string[right], string[left]
            left += 1
            right -= 1
        return "".join(string)
