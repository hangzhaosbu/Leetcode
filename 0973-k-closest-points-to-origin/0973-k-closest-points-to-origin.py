class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        pq = []
        for point in points:
            
            heapq.heappush(pq, [-point[0]*point[0]-point[1]*point[1],point[0],point[1]])
            
            if len(pq) > k:
                heapq.heappop(pq)
        
        ans = []
        while pq:
            ans.append([pq[0][1], pq[0][2]])
            heapq.heappop(pq)
        
        return ans