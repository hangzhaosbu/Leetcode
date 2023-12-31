class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> res;
        
        for(auto &num : nums)
        {
            int idx = lower_bound(res.begin(), res.end(), num) - res.begin();
            
            if(idx >= res.size())
            {
                res.push_back(num);
            }
            else
            {
                res[idx] = num;
            }
        }
        
        return res.size();
    }
};