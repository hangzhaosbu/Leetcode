class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int sum = 0;
        int ans = INT_MIN;
        
        for(int i = 0 ; i < nums.size(); i++)
        {
            sum += nums[i];
            
            if(sum < nums[i]) sum = nums[i];
            
            ans = max(ans, sum);
        }
        
        return ans;
    }
};