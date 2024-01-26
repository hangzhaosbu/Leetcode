class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        hashmap = {0:-1}
        total = 0
        
        for i, num in enumerate(nums):
            total += num
            if total % k in hashmap and i - hashmap[total % k] >= 2:
                return True
            if total % k not in hashmap:
                hashmap[total % k] = i
        return False