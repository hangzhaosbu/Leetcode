class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashmap = {}
        
        for c in s:
            hashmap[c] = hashmap.get(c, 0) + 1
        
        
        ans = ""
        for c in order:
            if c in hashmap:
                ans += c * hashmap[c]
                hashmap.pop(c)
                
        for c in hashmap:
            ans += c * hashmap[c]
        
        return ans