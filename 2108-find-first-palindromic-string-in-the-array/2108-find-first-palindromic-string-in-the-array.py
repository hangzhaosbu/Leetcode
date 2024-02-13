class Solution:
    def firstPalindrome(self, words: List[str]) -> str:
        
        
        
        def valid(s):
            l = 0
            r = len(s) - 1
            
            while l < r:
                if s[l] == s[r]:
                    l += 1
                    r -= 1
                else:
                    return False
            return True
        
        for word in words:
            if valid(word):
                return word
        
        return ""