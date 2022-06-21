class Solution {
    public int[] countBits(int n) {
        /*
        0000
        0001
        0010
        0011
        0100
        0101
        0110
        0111
        1000
        1001
        1010
        1011
        1100
        1101
        1110
        1111
        [0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4]
        
         0 1 2 2 4 4 4 4 8 8 8 8 8 8 8 8
         
         0: 0
         1: 1
         2: 2
         4: 4
         8: 8
         0 1 2 3 4 5
        */
        
        int[] dp = new int[n + 1];
        int base = 0, j = 0;
        
        for(int i = 1; i < n + 1; i++)
        {
            if(valid(i))
                j = i;
            
            if(i - j >= 0)
                dp[i] = dp[i - j] + 1;
        }
        
        return dp;
    }
    
    private boolean valid(int num)
    {
        while(num % 2 == 0)
        {
            num /= 2;
        }
        
        return num == 1;
    }
}