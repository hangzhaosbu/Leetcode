class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        l, r = max(weights), 25000000
        
        
        def valid(c):
            total = 0
            count = 0
            for weight in weights:
                if total + weight <= c:
                    total += weight
                else:
                    count += 1
                    total = weight
            
            if total:
                count += 1
            
            return count <= days
        
        while l < r:
            mid = (r - l) // 2 + l
            
            if valid(mid):
                r = mid
            else:
                l = mid + 1
        
        return l