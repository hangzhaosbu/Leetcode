class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return '1'
        
        s = self.countAndSay(n - 1)
        
        l = len(s)
        
        i, j = 0, 0
        ans = ""
        
        while i < l:
            while j < l and s[j] == s[i]:
                j += 1
            
            ans += str(j - i) + s[i]
        
            i = j
        
        return ans