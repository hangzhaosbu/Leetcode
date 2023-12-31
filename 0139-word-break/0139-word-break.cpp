class Solution {
public:
    int dp[1001][1001];
    bool wordBreak(string s, vector<string>& wordDict)
    {
        memset(dp, -1, sizeof(dp));
        unordered_set<string> set;
        for(auto& word : wordDict)
        {
            set.insert(word);
        }
        
        return dfs(0, s, set);
    }
    
    bool dfs(int idx, string s, unordered_set<string>& set)
    {
        if(idx == s.length())
        {
            dp[0][s.length() - 1] = 1;
            return true;
        }
        
        if(dp[0][idx] != -1) return dp[0][idx];
        
        for(int i = idx; i < s.length(); i++)
        {
            if(set.find(s.substr(idx, i - idx + 1)) != set.end())
                
            {
                dp[idx][i] = 1;
                if(dfs(i + 1, s, set))
                {
                    dp[i + 1][s.length() - 1] = 1;
                    return true;
                }
            }
        }
        
        dp[0][idx] = 0;
        return false;
    }
};