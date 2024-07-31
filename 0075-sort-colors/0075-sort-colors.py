class Solution:
    def sortColors(self, nums: List[int]) -> None:
        i, j = 0, len(nums) - 1
        t = 0
        """
        [2,0,2,1,1,0]
        [0,0,1,1,2,2]
        
        """
        
        
        while t <= j:
            if nums[t] == 0:
                nums[t], nums[i] = nums[i], nums[t]
                i+=1
                t+=1
            elif nums[t] == 2:
                nums[t], nums[j] = nums[j], nums[t]
                j-=1
            else:
                t+=1
        
        
                
        