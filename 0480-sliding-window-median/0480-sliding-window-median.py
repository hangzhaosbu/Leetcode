from sortedcontainers import SortedList

class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        l = SortedList()
        ans = []
        
        for i in range(len(nums)):
            l.add(nums[i])
            
            if i - k >= 0:
                l.remove(nums[i - k])
                
            if i >= k - 1:
                if k % 2 == 0:
                    ans.append((l[k//2 - 1] + l[k//2])/2)
                else:
                    ans.append(l[k//2])
        
        return ans