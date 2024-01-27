class Solution:
    def minInsertions(self, s: str) -> int:
        balance = 0
        ans = 0
        i = 0
        while i < len(s):
            if s[i] == '(':
                balance += 1
            else:
                
                if i + 1 < len(s) and s[i + 1] == ')':
                    balance -= 1
                    i += 1
                else:
                    ans += 1
                    balance -= 1
            
            if balance < 0:
                ans += 1
                balance = 0
            
            i += 1
        
        return balance*2 + ans