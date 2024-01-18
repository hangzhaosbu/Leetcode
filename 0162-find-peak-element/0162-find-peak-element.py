class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1
        
        while l < r:
            mid = (r - l) // 2 + l
            
            if nums[mid] < nums[mid + 1]:
                l = mid + 1
                
            else:
                r = mid
                
        
        
        return l