"""
本代码来自 CSON 官方视频课程，由 @CSON 提供
题目来源：http://leetcode.com
- CSON 致力于在 CS 领域内帮助中国人找到工作，让更多海内外国人受益
- 讲师：Edward Shi
- 官方网站：https://cspiration.com
- 版权归 CSON 所有，转发请注明出处
"""


class NumMatrix:
    matrix = None
    tree = None
    m = 0
    n = 0

    def __init__(self, matrix: List[List[int]]):
        if len(matrix) == 0 or len(matrix[0]) == 0: return
        self.m = len(matrix)
        self.n = len(matrix[0])
        self.tree = [[0 for _ in range(self.n + 1)] for _ in range(self.m + 1)]
        self.matrix = [[0 for _ in range(self.n)] for _ in range(self.m)]
        for i in range(self.m):
            for j in range(self.n):
                self.update(i, j, matrix[i][j])

    def update(self, row: int, col: int, val: int) -> None:
        if self.m == 0 or self.n == 0: return
        diff = val - self.matrix[row][col]
        self.matrix[row][col] = val
        i = row + 1
        while i <= self.m:
            j = col + 1
            while j <= self.n:
                self.tree[i][j] += diff
                j += (j & -j)
            i += (i & -i)

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        if self.m == 0 or self.n == 0: return 0
        return self.getSum(row2 + 1, col2 + 1) - self.getSum(row1, col2 + 1) \
               - self.getSum(row2 + 1, col1) + self.getSum(row1, col1)

    def getSum(self, row: int, col: int) -> int:
        total = 0
        i = row
        while i > 0:
            j = col
            while j > 0:
                total += self.tree[i][j]
                j -= (j & -j)
            i -= (i & -i)
        return total

# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# obj.update(row,col,val)
# param_2 = obj.sumRegion(row1,col1,row2,col2)
