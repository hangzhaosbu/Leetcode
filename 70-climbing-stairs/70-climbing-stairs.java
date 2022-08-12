class Solution {
    int[] memo = new int[46];
    
    public int climbStairs(int n) {
        if(n < 3){
            memo[n] = n;
            return n;
        }
        
        if(memo[n] != 0)
        {
            return memo[n];
        }
        
        memo[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}