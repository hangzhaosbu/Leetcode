class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        def quickselect(l, r, k):
            if l == r:
                return nums[l]
            
            mid = (r - l) // 2 + l
            pivot = nums[mid]
            
            i, t, j = l, l, r
            
            while t <= j:
                if nums[t] > pivot:
                    nums[t], nums[j] = nums[j], nums[t]
                    j-=1
                elif nums[t] < pivot:
                    nums[t], nums[i] = nums[i], nums[t]
                    i+=1
                    t+=1
                else:
                    t+=1
                    
            if r - j + 1 == k:
                return nums[j]
            elif r - j + 1 > k:
                return quickselect(j + 1, r, k)
            else:
                if j - i >= 99000:
                    return nums[i]
                return quickselect(l, j - 1, k - (r - j + 1))
        
        return quickselect(0, len(nums) - 1, k)