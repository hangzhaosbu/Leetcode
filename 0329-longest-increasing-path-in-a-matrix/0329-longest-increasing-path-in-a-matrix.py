class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        
        dp = [[-1 for _ in range(n)] for _ in range(m)]
        ans = 0
        
        def dfs(i, j):
            if dp[i][j] != -1:
                return dp[i][j]
            
            used = 0
            
            for direction in [[1,0],[-1,0],[0,1],[0,-1]]:
                newx, newy = i + direction[0], j + direction[1]
                
                if newx < 0 or newx >= len(matrix) or newy < 0 or newy >= len(matrix[0]):
                    continue
                
                if matrix[newx][newy] <= matrix[i][j]:
                    continue
                    
                used = max(used, dfs(newx, newy))
            
            dp[i][j] = used + 1
            return dp[i][j]
        
        for i in range(m):
            for j in range(n):
                ans = max(ans, dfs(i, j))
        
        return ans
        
                
                