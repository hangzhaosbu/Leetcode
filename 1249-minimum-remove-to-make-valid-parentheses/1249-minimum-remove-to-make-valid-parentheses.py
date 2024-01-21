class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        
        
        def helper(s, open, close):
            balance = 0
            ans = ""

            for c in s:
                if c == open:
                    balance+=1
                elif c == close:
                    balance-=1
                if balance == -1:
                    balance = 0
                else:
                    ans += c
            return ans
        
        s = helper(s, "(", ")")
        s = s[::-1]
        s = helper(s, ")", "(")
        s = s[::-1]
        return s