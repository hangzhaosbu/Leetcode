class Solution {
    public String longestPalindrome(String s) {
        int N = s.length();
        int start = 0, end = 0, max_len = 0;
        
        boolean[][] dp = new boolean[N][N];
        
        for(int i = 0; i < N; i++)
        {
            dp[i][i] = true;
            
            if(i + 1 < N && s.charAt(i) == s.charAt(i + 1))
            {
                dp[i][i + 1] = true;
            }
        }
        
        for(int len = 1; len <= N; len++)
        {
            for(int i = 0; i + len - 1 < N; i++)
            {
                int j = i + len - 1;
                
                if(i + 1 <= j - 1 && s.charAt(i) == s.charAt(j))
                {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                
                
                if(dp[i][j] && j - i + 1 > max_len)
                {
                    max_len = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        
        return s.substring(start, end + 1);
    }
}