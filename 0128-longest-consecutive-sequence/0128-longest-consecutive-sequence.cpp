class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> hashset(begin(nums), end(nums));
        int ans = 0;
        
        for(auto& num : nums)
        {
            if(hashset.find(num - 1) != hashset.end()) continue;
            
            int count = 0;
            
            while(hashset.find(num) != hashset.end())
            {
                count++;
                num++;
            }
            
            ans = max(ans, count);
        }
        
        return ans;
    }
};