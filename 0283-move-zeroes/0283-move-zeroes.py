class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = 0
        zeros = 0
        for num in nums:
            if num == 0:
                zeros += 1
        
        for j in range(len(nums)):
            if nums[j] != 0:
                nums[i] = nums[j]
                i+=1
                
                if j >= len(nums) - zeros:
                    nums[j] = 0
        