class Solution:
    def maximumSwap(self, num: int) -> int:
        num = list(map(int, str(num)))
        last = [0 for _ in range(10)]
        
        
        for i in range(len(num)):
            last[num[i]] = i
        
        for i in range(len(num)):
            for d in range(9, -1, -1):
                if d > num[i] and last[d] > i:
                    num[i], num[last[d]] = num[last[d]], num[i]
        
                    return int("".join(map(str, num)))
        
        return int("".join(map(str, num)))
            
        
        
        
        