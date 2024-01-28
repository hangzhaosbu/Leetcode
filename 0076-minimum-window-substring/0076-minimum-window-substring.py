class Solution:
    def minWindow(self, s: str, t: str) -> str:
        countT, window = {}, {}
        l = 0
        res, resLen = [-1,-1], float("inf")
        
        for c in t:
            countT[c] = countT.get(c, 0) + 1
        
        have, want = 0, len(countT)
        
        for r in range(len(s)):
            c = s[r]
            
            window[c] = window.get(c, 0) + 1
            if c in countT and window[c] == countT[c]:
                have += 1
            while have == want:
                if r - l + 1 < resLen:
                    resLen = r - l + 1
                    res = [l, r]
                window[s[l]] -= 1
                if s[l] in countT and window[s[l]] < countT[s[l]]:
                    have -= 1
                l += 1
        
        l, r = res
        return s[l:r + 1] if resLen != float("inf") else ""