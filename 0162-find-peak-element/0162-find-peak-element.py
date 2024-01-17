class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        nums = [float("-inf")] + nums + [float("-inf")]
        
        l, r = 1, len(nums) - 2
        
        while l <= r:
            mid = (r - l) // 2 + l
            if nums[mid] > nums[mid - 1] and nums[mid] < nums[mid + 1]:
                l = mid + 1
            
            elif nums[mid] < nums[mid - 1] and nums[mid] > nums[mid + 1]:
                r = mid - 1
            elif nums[mid] < nums[mid - 1] and nums[mid] < nums[mid + 1]:
                if nums[mid] < nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1
            else:
                return mid - 1
        
        
        return l