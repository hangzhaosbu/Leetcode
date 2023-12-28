class Solution {
public:
    int rob2(vector<int>& nums) {
        if(nums.size() == 1) return nums[0];
        else if(nums.size() == 2) return max(nums[0], nums[1]);
        
        vector<int>dp(nums.size(), 0);
        
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);
        
        for(int i = 2; i < nums.size(); i++)
        {
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        
        return dp[nums.size() - 1];
    }
    
    int rob(vector<int>& nums) {
        if(nums.size() == 1) return nums[0];
        vector<int> first;
        vector<int> second;
        
        for(int i = 0; i < nums.size() - 1; i++) first.push_back(nums[i]);
        for(int i = 1; i < nums.size(); i++) second.push_back(nums[i]);
        
        return max(rob2(first), rob2(second));
    }
};