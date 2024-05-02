class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        ans = -1
        for num in nums:
            if num > ans and -num in nums:
                ans = num
        
        return ans