class Solution {
public:
    int numDecodings(string s) {
        vector<int>dp(s.length() + 1, 0);
        dp[0] = 1;
        s = "#" + s;
        for(int i = 1; i< s.length(); i++)
        {
            if(dp[i - 1] > 0 && s[i] >= '1' && s[i] <= '9')
                dp[i] = dp[i - 1];
            if(i > 1 && dp[i - 2] > 0 && stoi(s.substr(i - 1, 2)) >= 10 && stoi(s.substr(i - 1, 2)) <= 26)
            {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length() - 1];
    }
};