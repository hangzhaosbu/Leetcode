class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        hashmap = {}
        hashmap[0] = -1
        
        prefixSum = []
        total = 0
        
        for num in nums:
            total += num
            
            prefixSum.append(total)
        
        for i, num in enumerate(prefixSum):
            
            curt = num % k
            
            if curt in hashmap and abs(i - hashmap[curt]) > 1:
                return True
            
            if curt not in hashmap:
                hashmap[curt] = i
        
        return False
        
        