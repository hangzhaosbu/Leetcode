class Solution {
    public int numDecodings(String s) {
        int N = s.length();
        int[] dp = new int[N + 1];
        dp[0] = 1;
        
        for(int i = 1; i < N + 1; ++i)
        {
            int onedigit = Integer.parseInt(s.substring(i - 1, i));
            if(onedigit >= 1 && onedigit < 10)
            {
                dp[i] = dp[i - 1];
            }
            
            if(i - 2 >= 0)
            {
                int twodigits = Integer.parseInt(s.substring(i - 2, i));
                
                if(twodigits >= 10 && twodigits <= 26){
                    dp[i] += dp[i - 2];
                }
            }
        }
        
        
        return dp[N];
    }
}