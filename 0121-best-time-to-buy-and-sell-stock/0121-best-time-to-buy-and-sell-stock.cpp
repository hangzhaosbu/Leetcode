class Solution {
public:
    int minVal = INT_MAX;
    int ans = 0;
    int maxProfit(vector<int>& prices) {
        for(auto & price : prices)
        {
            ans = max(ans, price - minVal);   
            minVal = min(minVal, price);
        }
        
        return ans;
    }
};