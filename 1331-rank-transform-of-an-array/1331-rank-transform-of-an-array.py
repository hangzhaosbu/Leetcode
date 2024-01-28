class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        hashmap = {}
        res = [0 for _ in range(len(arr))]
        count = 1
        
        for i, num in enumerate(arr):
            if num not in hashmap:
                hashmap[num] = []
                
            hashmap[num].append(i)
        
        for key in sorted(hashmap.keys()):
            
            for idx in hashmap[key]:
                res[idx] = count
            
            count += 1
        
        return res