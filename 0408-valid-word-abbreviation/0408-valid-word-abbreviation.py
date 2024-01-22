class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        m, n = len(word), len(abbr)
        
        i, j = 0, 0
        
        while i < m and j < n:
            if abbr[j] >= '0' and abbr[j] <= '9':
                
                if abbr[j] == '0':
                    return False
                
                else:
                    curt = 0
                    while j < n and abbr[j] >= '0' and abbr[j] <= '9':
                        curt = curt * 10 + ord(abbr[j]) - ord('0')
                        j += 1
                    
                    i += curt
            else:
                if word[i] == abbr[j]:
                    i += 1
                    j += 1
                else:
                    return False
        
        return i == m and j == n
                