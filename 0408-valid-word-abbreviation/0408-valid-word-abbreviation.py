class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        
        i, j = 0, 0
        m, n = len(word), len(abbr)
        
        
        while i < m and j < n:
            if word[i] == abbr[j]:
                i+=1
                j+=1
            else:
                
                if abbr[j] >= '1' and abbr[j] <= '9':
                
                    num = 0
                    while j < n and abbr[j] >= '0' and abbr[j] <= '9':
                        num = 10 * num + ord(abbr[j]) - ord('0')
                        j+=1

                    i+=num
                else:
                    return False
        
        return i == m and j == n