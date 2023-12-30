class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int n = nums.size(), ans = 0;
        vector<int> positive(n, 0);
        vector<int> negative(n, 0);
        
        positive[0] = nums[0];
        negative[0] = nums[0];
        
        ans = max(positive[0], negative[0]);
        
        for(int i = 1; i < n; i++)
        {
            int num = nums[i];
            
            positive[i] = max(nums[i], max(nums[i] * positive[i - 1], nums[i] * negative[i - 1]));
            negative[i] = min(nums[i], min(nums[i] * negative[i - 1], nums[i] * positive[i - 1]));
            
            ans = max(ans, max(positive[i], negative[i]));
        }
        
        return ans;
    }
};