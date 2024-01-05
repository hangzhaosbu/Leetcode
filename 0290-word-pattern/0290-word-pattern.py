class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        s = s.split()
        if len(pattern) != len(s): return False
        
        dic = dict()
        
        for i in range(len(s)):
            key = pattern[i]
            value = s[i]
            
            
            if key not in dic:
                dic[key] = value
            else:
                if dic[key] != value:
                    return False
        
        
        return len(set(pattern)) == len(set(dic.values()))