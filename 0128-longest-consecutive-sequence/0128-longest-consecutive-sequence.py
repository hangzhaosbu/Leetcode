class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        hashset = set(nums)
        ret = 0
        for num in nums:
            if num - 1 in hashset:
                continue
            count = 1
            while num + 1 in hashset:
                count += 1
                num += 1
            
            ret = max(ret, count)
        
        return ret