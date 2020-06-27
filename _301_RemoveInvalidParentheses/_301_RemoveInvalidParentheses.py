"""
本代码来自 CSON 官方视频课程，由 @CSON 提供
题目来源：http://leetcode.com
- CSON 致力于在 CS 领域内帮助中国人找到工作，让更多海内外国人受益
- 讲师：Edward Shi
- 官方网站：https://cspiration.com
- 版权归 CSON 所有，转发请注明出处
"""


class _301_RemoveInvalidParentheses:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        count_left, count_right = 0, 0
        result = []
        string = list(s)
        for i in range(len(string)):
            if string[i] == '(':
                count_left += 1
            if count_left == 0:
                if string[i] == ')':
                    count_right += 1
            else:
                if string[i] == ')':
                    count_left -= 1
        self.dfs(string, 0, count_left, count_right, result)
        return result

    def dfs(self, s: List[str], start: int, count_left: int, count_right: int, result: List[str]) -> None:
        if count_left == 0 and count_right == 0 and self.isValid(s) and "".join(s) not in result:
            result.append("".join(s))
            return
        for i in range(start, len(s)):
            if i != start and s[i] == s[i - 1]: continue
            if s[i] == '(' or s[i] == ')':
                new_s = s[:i] + s[i + 1:]
                if count_right > 0 and s[i] == ')':
                    self.dfs(new_s, i, count_left, count_right - 1, result)
                elif count_left > 0 and s[i] == '(':
                    self.dfs(new_s, i, count_left - 1, count_right, result)

    def isValid(self, s: List[str]) -> bool:
        count = 0
        for i in range(len(s)):
            if s[i] == '(':
                count += 1
            if s[i] == ')':
                count -= 1
            if count < 0: return False
        return count == 0
