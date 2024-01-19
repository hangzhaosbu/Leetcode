class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if sum([sum(x) for x in matrix]) == 0:
            return 0
        
        m, n = len(matrix), len(matrix[0])
        
        dp = [[float("inf") for _ in range(n)] for _ in range(m)]
        ans = float("inf")
        
        def dfs(x, y, m, n):
            if x == m:
                return 0
            
            if dp[x][y] != float("inf"):
                return dp[x][y]
            
            total = float("inf")
            
            for newy in [y - 1, y, y + 1]:
                newx = x + 1
                
                if newy < 0 or newy >= n:
                    continue
                
                total = min(total, dfs(newx, newy, m, n))
            
            dp[x][y] = total + matrix[x][y]
            return total + matrix[x][y]
        
        
        for j in range(n):
            ans = min(ans, dfs(0, j, m, n))
        
        
        return ans
                
                