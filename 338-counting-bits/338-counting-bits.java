class Solution {
    public int[] countBits(int n)
    {   //   i  0, 1,  2   3   4
        //count:   01  1   1  
        //dp    0  1   1   2   2
        // [0, 1, 1, 2, 1, 2, 2, 3, 1]
        //  0  1  2  3  4  5
        //     1  2  2  4  4  4  4  8
        int[] dp = new int[n + 1];
        int count = 1;
        
        for(int i = 1; i <= n; ++i)
        {
            if(i == count*2)
            {
                count*=2;
            }
            dp[i] = dp[i - count] + 1;
        }
        
        return dp;
    }
}