class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        i, j, n, ans = 0, 0, len(nums), 0
        
        while i < n:
            while j < n and (nums[j] > 0 or nums[j] < 1 and k > 0):
                k -= nums[j] == 0
                j += 1
            ans = max(ans, j - i)
            k += nums[i] == 0
            i += 1
        return ans