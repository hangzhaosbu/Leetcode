class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hashmap = {0:1}
        total = 0
        ans = 0
        
        for num in nums:
            total += num
            
            if total - k in hashmap:
                ans += hashmap[total - k]
            
            hashmap[total] = hashmap.get(total, 0) + 1
        
        return ans