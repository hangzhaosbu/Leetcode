class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        hashmap = {'a':0,'b':0,'c':0}
        
        i, j, n = 0, 0, len(s)
        ans = 0
        
        while i < n:
            while j < n and not (hashmap['a'] > 0 and hashmap['b'] > 0 and hashmap['c'] > 0):
                hashmap[s[j]] = hashmap.get(s[j], 0) + 1
                
                j += 1
            
            
            if hashmap['a'] > 0 and hashmap['b'] > 0 and hashmap['c'] > 0:
                ans += n - j + 1
            
            hashmap[s[i]]-=1
            i += 1
        
        return ans