class Solution:
    def isValidPalindrome(self, s: str, k: int) -> bool:
        n = len(s)
        
        dp = [[-1 for _ in range(n)] for _ in range(n)]
        
        def dfs(i, j):
            if dp[i][j] != -1:
                return dp[i][j]
            
            elif i == j:
                dp[i][i] = 0
                return 0
            
            elif i + 1 == j:
                if s[i] != s[j]:
                    dp[i][j] = 1
                else:
                    dp[i][j] = 0
                return dp[i][j]
            
            if s[i] == s[j]:
                dp[i][j] = dfs(i + 1, j - 1)
            else:    
                dp[i][j] = 1 + min(dfs(i + 1, j), dfs(i, j - 1))
            return dp[i][j]
        
        
        return dfs(0, n - 1) <= k
        
        
            
                