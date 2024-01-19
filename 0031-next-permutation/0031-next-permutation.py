class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        i = len(nums) - 1
        
        while i - 1 >= 0 and nums[i - 1] >= nums[i]:
            i-=1
            
        if i == 0:
            
            l, r = 0, len(nums) - 1
            
            while l < r:
                nums[l], nums[r] = nums[r], nums[l]
                l+=1
                r-=1
        else:
            i -= 1
            target = nums[i]
            
            j = i + 1
            diff = float("inf")
            k = 0
            
            while j < len(nums):
                
                if nums[j] > target and nums[j] - target <= diff:
                    diff = nums[j] - target
                    k = j
                j += 1
            
            
            nums[i], nums[k] = nums[k], nums[i]
            
            l, r = i + 1, len(nums) - 1
            
            while l < r:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
                r -= 1