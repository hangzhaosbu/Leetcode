class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        hashmap = {}
        hashmap[0] = -1
        
        for i in range(1, len(nums)):
            nums[i] += nums[i - 1]
        
        for i, num in enumerate(nums):
            
            curt = num % k
            
            if curt in hashmap and abs(i - hashmap[curt]) > 1:
                return True
            
            if curt not in hashmap:
                hashmap[curt] = i
        
        return False
        
        