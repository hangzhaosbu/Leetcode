class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.length();
        vector<vector<int>>dp(n, vector<int>(n, 0));
        int ans = 0, start = 0, end = 0;
        
        for(int i = 0; i < n; i++)
        {
            dp[i][i] = 1;
            
            if(i > 0 && s[i] == s[i - 1])
            {
                dp[i - 1][i] = 2;
                start = i - 1;
                end = i;
            }
        }
        
        for(int len = 3; len <= s.length(); len++)
        {
            for(int i = 0; i + len - 1 < n; i++)
            {
                int j = i + len - 1;
                
                if(s[i] == s[j] && dp[i + 1][j - 1] != 0)
                {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else
                {
                    dp[i][j] = 0;
                }
                
                
                if(dp[i][j] > ans)
                {
                    ans = dp[i][j];
                    start = i;
                    end = j;
                }
            }
        }
        
        return s.substr(start, end - start + 1);
    }
};