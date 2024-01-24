class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        l, r = 0, 0
        
        for c in s:
            if c == '(':
                l += 1
            elif c == ')':
                if l > 0:
                    l -= 1
                else:
                    r += 1
        
        ans = []
        
        
        def valid(s):
            balance = 0
            
            for c in s:
                if c == '(':
                    balance += 1
                elif c == ')':
                    balance -= 1
                    
                if balance < 0:
                    return False
            
            return balance == 0
        
        def dfs(start, s, l, r):
            if l == 0 and r == 0:
                if valid(s):
                    ans.append(s[:])
                return
            
            for i in range(start, len(s)):
                if i != start and s[i] == s[i - 1]:
                    continue
                
                if s[i] == '(' or s[i] == ')':
                    newS = s[:i] + s[i + 1:]

                    if s[i] == '(' and l > 0:
                        dfs(i, newS, l - 1, r)
                    elif s[i] == ')' and r > 0:
                        dfs(i, newS, l, r - 1)
        
        
        dfs(0, s, l, r)
        
        return ans
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            