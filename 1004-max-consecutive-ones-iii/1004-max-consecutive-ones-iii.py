class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        i = 0
        j = 0
        
        n = len(nums)
        ans = 0
        
        while i < n:
            while j < n and (nums[j] == 1 or nums[j] == 0 and k > 0):
                if nums[j] == 0:
                    k -= 1
                j += 1
            
            ans = max(ans, j - i)
            if nums[i] == 0:
                k += 1
            i += 1
        
        return ans