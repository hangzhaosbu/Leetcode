class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        """
        [1,5,9]
        [10,11,13]
        [12,13,15]
        """
        pq = []
        
        for i in range(len(matrix)):
            heapq.heappush(pq, [matrix[i][0], i, 0])
        
        
        while len(pq) > 0 and k != 1:
            val, x, y = pq[0]
            heapq.heappop(pq)
            
            if y + 1 < len(matrix[0]):
                heapq.heappush(pq, [matrix[x][y + 1], x, y + 1])
            
            k -= 1
        
        return pq[0][0]
            
        