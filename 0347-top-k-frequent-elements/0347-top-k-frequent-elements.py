class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hashmap = {}
        
        for num in nums:
            hashmap[num] = hashmap.get(num, 0) + 1
        
        candidates = []
        
        for key, val in hashmap.items():
            candidates.append([key, val])
        
        candidates.sort(key=lambda x : -x[1])
        
        # print(candidates)
        
        return [x[0] for x in candidates[:k]]