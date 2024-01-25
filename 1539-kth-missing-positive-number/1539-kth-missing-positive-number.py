class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        n = 1
        
        for num in arr:
            while n < num:
                k-=1
                
                if k == 0:
                    return n
                n+=1
            
            if n == num:
                n+=1
        
        while k > 0:
            k-=1
            
            if k == 0:
                return n
            n+=1
        
        return -1