class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hashmap = {}
        hashmap[0] = 1
        
        total = 0
        count = 0
        # 0:1, 1:1
        """
        [1]
        0
        [-1,-1,1]
        0
        
        """
        for num in nums:
            total += num
            if total - k in hashmap:
                count += hashmap[total - k]
                
            
            hashmap[total] = hashmap.get(total, 0) + 1
        return count