class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        countT, window = {}, {}
        
        for c in s1:
            countT[c] = countT.get(c, 0) + 1
        
        have, need = 0, len(countT)
        s1l, s2l = len(s1), len(s2)
        
        
        
        for r in range(len(s2)):
            if r - len(s1) >= 0:
                cc = s2[r - len(s1)]
                window[cc] = window[cc] - 1
                    
            c = s2[r]
            
            window[c] = window.get(c, 0) + 1
            
            if c in countT and window[c] == countT[c]:
                have += 1
            
            
            valid = True
            for count in countT:
                if count in window and window[count] == countT[count]:
                    pass
                else:
                    valid = False
                    break
            if valid:
                break
            
        
        return valid