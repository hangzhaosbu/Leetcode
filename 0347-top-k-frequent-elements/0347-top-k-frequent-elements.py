class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hashmap = {}
        
        for num in nums:
            hashmap[num] = hashmap.get(num, 0) + 1
        
        candidates = []
        
        for key, val in hashmap.items():
            candidates.append([key,val])
            
            
        def quickselect(l, r, k):
            if l == r:
                return [candidates[l][0]]
            
            mid = (r - l) // 2 + l
            pivot = candidates[mid][1]
            
            i, t, j = l, l, r
            
            while t <= j:
                if candidates[t][1] < pivot:
                    candidates[t], candidates[i] = candidates[i], candidates[t]
                    i += 1
                    t += 1
                elif candidates[t][1] > pivot:
                    candidates[t], candidates[j] = candidates[j], candidates[t]
                    j -= 1
                else:
                    t += 1
            
            # S S S S E E E E L L L L
            
            if r - j + 1 == k:
                return [x[0] for x in candidates[j:r + 1]]
            elif r - j + 1 > k:
                return quickselect(j + 1, r, k)
            else:
                return [x[0] for x in candidates[j:r + 1]] + quickselect(l, j - 1, k - (r - j + 1))
            
        return quickselect(0, len(candidates) - 1, k)