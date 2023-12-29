class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        dic = dict()
        
        for i in range(len(s)):
            
            if s[i] not in dic:
                dic[s[i]] = t[i]
            else:
                if dic[s[i]] != t[i]:
                    return False
                
                
        dic = dict()
        
        for i in range(len(s)):
            
            if t[i] not in dic:
                dic[t[i]] = s[i]
            else:
                if dic[t[i]] != s[i]:
                    return False
                
        
        return True