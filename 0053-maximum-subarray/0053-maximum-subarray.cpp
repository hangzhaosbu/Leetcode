class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int sum = 0;
        int ans = INT_MIN;
        
        for(auto & num : nums)
        {
            sum = sum < 0 ? num : sum + num;
            ans = max(ans, sum);
        }
        
        return ans;
    }
};