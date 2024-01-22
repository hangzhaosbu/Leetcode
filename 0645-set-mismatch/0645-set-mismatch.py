class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        hashmap = {}
        
        dup = 0
        missing = 0
        
        for num in nums:
            if num in hashmap:
                hashmap[num]+=1
            else:
                hashmap[num]=1
        
        for i in range(1, len(nums) + 1):
            if i not in hashmap:
                missing = i
            
            if i in hashmap and hashmap[i] > 1:
                dup = i
        
        return [dup, missing]
        