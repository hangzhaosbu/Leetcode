class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        queue = []
        ans = []
        for i in range(len(nums)):
            if i - k >= 0 and queue[0] == nums[i - k]:
                queue.pop(0)
            
            if not queue:
                queue.append(nums[i])
            else:
                
                while queue and queue[-1] < nums[i]:
                    queue.pop()
                
                queue.append(nums[i])
            
            
            if i >= k - 1:
                ans.append(queue[0])
        
        return ans
            
                