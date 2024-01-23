class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hashmap = {}
        pq = []
        ans = []
        
        for num in nums:
            hashmap[num] = hashmap.get(num, 0) + 1
        
        candidates = []
        
        for key, val in hashmap.items():
            heapq.heappush(pq, [val, key])
            
            if len(pq) > k:
                heapq.heappop(pq)
        
        while pq:
            ans.append(pq[0][1])
            heapq.heappop(pq)
        
        return ans