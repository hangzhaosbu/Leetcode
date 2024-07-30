class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        ret = []
        
        for i in range(n):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            curt = nums[i]
            
            l, r = i + 1, n - 1
            
            while l < r:
                
                left = nums[l]
                right = nums[r]
                
                total = curt + left + right
                
                if total == 0:
                    ret.append([curt, left, right])
                    l += 1
                    r -= 1
                    
                    while l < r and nums[l] == nums[l - 1]:
                        l += 1
                    
                    while l < r and nums[r] == nums[r + 1]:
                        r -= 1
                elif total < 0:
                    l += 1
                elif total > 0:
                    r -= 1
                    
        return ret
                