class Solution:
    def countAndSay(self, m: int) -> str:
        
        if m == 1:
            return "1"

        s = self.countAndSay(m - 1)

        i = 0
        j = 0
        ans = ""

        while i < len(s):

            while j < len(s) and s[j] == s[i]:
                j+=1

            ans += str(j - i) + s[i]
            i = j

        return ans
        