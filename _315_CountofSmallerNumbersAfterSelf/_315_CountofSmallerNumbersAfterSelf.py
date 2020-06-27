"""
本代码来自 CSON 官方视频课程，由 @CSON 提供
题目来源：http://leetcode.com
- CSON 致力于在 CS 领域内帮助中国人找到工作，让更多海内外国人受益
- 讲师：Edward Shi
- 官方网站：https://cspiration.com
- 版权归 CSON 所有，转发请注明出处
"""


class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        result = [0 for _ in nums]
        array = []
        for i in range(len(nums) - 1, -1, -1):
            index = self.find(array, nums[i])
            result[i] = index
            array.insert(index, nums[i])
        return result

    def find(self, array: List[int], target: int) -> int:
        if len(array) == 0:
            return 0
        start = 0
        end = len(array) - 1
        if array[end] < target:
            return end + 1
        if array[start] >= target:
            return 0
        while start + 1 < end:
            mid = int((end - start) / 2 + start)
            if target <= array[mid]:
                end = mid
            else:
                start = mid + 1
        if target <= array[start]:
            return start
        return end
