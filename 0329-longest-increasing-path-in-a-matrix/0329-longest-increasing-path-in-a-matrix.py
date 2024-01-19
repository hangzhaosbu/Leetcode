class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        
        m, n = len(matrix), len(matrix[0])
        directions = [[1,0],[-1,0],[0,1],[0,-1]]
        dp = [[0 for _ in range(n)] for _ in range(m)]
        ans = 0
        
        def dfs(x, y, m, n):
            if dp[x][y] != 0:
                return dp[x][y]
            
            steps = 0
            
            for direction in directions:
                newx = x + direction[0]
                newy = y + direction[1]
                
                if newx < 0 or newx >= m or newy < 0 or newy >= n:
                    continue
                    
                if matrix[newx][newy] <= matrix[x][y]:
                    continue
                
                steps = max(steps, dfs(newx, newy, m, n))
            
            dp[x][y] = steps + 1
            return dp[x][y]
        
        for i in range(m):
            for j in range(n):
                ans = max(ans, dfs(i, j, m, n))
                
        
        return ans