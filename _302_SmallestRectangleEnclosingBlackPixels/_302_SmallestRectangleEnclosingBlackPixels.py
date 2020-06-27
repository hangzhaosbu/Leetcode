"""
本代码来自 CSON 官方视频课程，由 @CSON 提供
题目来源：http://leetcode.com
- CSON 致力于在 CS 领域内帮助中国人找到工作，让更多海内外国人受益
- 讲师：Edward Shi
- 官方网站：https://cspiration.com
- 版权归 CSON 所有，转发请注明出处
"""


class _302_SmallestRectangleEnclosingBlackPixels:
    def minArea(self, image: List[List[str]], x: int, y: int) -> int:
        if image == None or len(image) == 0 or len(image[0]) == 0: return 0
        row = len(image)
        col = len(image[0])
        left = self.binarySearchLeft(image, 0, y, True)
        right = self.binarySearchRight(image, y, col - 1, True)
        top = self.binarySearchLeft(image, 0, x, False)
        bottom = self.binarySearchRight(image, x, row - 1, False)
        return (right - left + 1) * (bottom - top + 1)

    def binarySearchLeft(self, image: List[List[str]], left: int, right: int, isHor: bool) -> int:
        while left + 1 < right:
            mid = int((right - left) / 2 + left)
            if self.hasBlack(image, mid, isHor):
                right = mid
            else:
                left = mid
        if self.hasBlack(image, left, isHor):
            return left
        return right

    def binarySearchRight(self, image: List[List[str]], left: int, right: int, isHor: bool) -> int:
        while left + 1 < right:
            mid = int((right - left) / 2 + left)
            if self.hasBlack(image, mid, isHor):
                left = mid
            else:
                right = mid
        if self.hasBlack(image, right, isHor):
            return right
        return left

    def hasBlack(self, image: List[List[str]], target: int, isHor: bool) -> bool:
        if isHor:
            for i in range(len(image)):
                if image[i][target] == '1':
                    return True
            return False
        else:
            for i in range(len(image[0])):
                if image[target][i] == '1':
                    return True
            return False
