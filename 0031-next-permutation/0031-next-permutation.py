class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = len(nums) - 1
        
        while i > 0 and nums[i] <= nums[i - 1]:
            i -= 1
        
        i -= 1
        
        if i < 0:
            
            l, r = 0, len(nums) - 1
            
            while l < r:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
                r -= 1
            
            return
        
        else:
            
            j = i + 1
            diff = float("inf")
            k = 0
            
            while j < len(nums):
                if nums[j] > nums[i] and nums[j] - nums[i] <= diff:
                    diff = nums[j] - nums[i]
                    k = j
                j += 1
            
            nums[i], nums[k] = nums[k], nums[i]
            
            l, r = i + 1, len(nums) - 1
            
            while l < r:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
                r -= 1
            
                
            
            
                