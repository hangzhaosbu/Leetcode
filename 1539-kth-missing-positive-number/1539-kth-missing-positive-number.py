class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        j = 1
        
        for i in arr:
            
            while j < i:
                if k == 1:
                    return j
                
                j += 1
                k -= 1
            
            if j == i:
                j += 1
        
        while k > 1:
            if k == 1:
                return j
            
            
            j += 1
            k -= 1
        
        return j
                
                