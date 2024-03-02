class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        return [y**2 for y in sorted(nums, key=lambda x: abs(x))]