class Solution:
    dp = [0 for _ in range(46)]
    def climbStairs(self, n: int) -> int:
        if n == 1 or n == 2:
            return n
        
        if self.dp[n] != 0:
            return self.dp[n]
        
        
        self.dp[n] = self.climbStairs(n - 1) + self.climbStairs(n - 2)
        return self.dp[n]