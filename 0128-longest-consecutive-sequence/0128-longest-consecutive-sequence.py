class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        hashset = set(nums)
        ans = 0
        
        for num in nums:
            if num - 1 not in hashset:
                count = 0
                
                while num in hashset:
                    count += 1
                    num += 1
                
                ans = max(ans, count)
        
        return ans