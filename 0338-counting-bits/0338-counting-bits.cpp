class Solution {
public:
    vector<int> countBits(int n) {
        if (n == 0) return {0};
        else if (n == 1) return {0,1};
         
        vector<int> dp(n + 1, 0);
        dp[0] = 0;
        dp[1] = 1;
        
        //2-3 -> 2
        //4-7 -> 4
        //8-15 ->8
        int p = 1;
        
        for(int i = 2; i <= n; i++)
        {
            if((int) pow(2, p + 1) == i) p++;
            dp[i] = dp[i - (int) pow(2, p)] + 1;
        }
        
        return dp;
    }
};