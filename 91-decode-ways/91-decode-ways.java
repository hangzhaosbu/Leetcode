class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        
        for(int i = 1; i < s.length() + 1; ++i)
        {
            if(s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '9')
            {
                dp[i] += dp[i - 1];
            }
            
            
            if(i >= 2 && Integer.parseInt(s.substring(i - 2, i)) >= 10 && Integer.parseInt(s.substring(i - 2, i)) <= 26)
            {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}