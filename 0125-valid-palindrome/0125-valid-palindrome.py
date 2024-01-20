class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        
        l, r = 0, len(s) - 1
        
        while l < r:
            while l < r and s[l] not in "0123456789abcdefghijklmnopqrstuvwxyz":
                l+=1
            
            while l < r and s[r] not in "0123456789abcdefghijklmnopqrstuvwxyz":
                r-=1
            
            if s[l] == s[r]:
                l+=1
                r-=1
            else:
                return False
        
        return True