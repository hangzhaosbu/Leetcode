class Solution {
public:
    vector<vector<int>> findMatrix(vector<int>& nums) {
        unordered_map<int,int> map;
        
        for(auto& num : nums)
        {
            map[num]++;
        }
        
        int maxVal = 0;
        
        for(auto& [key, value] : map)
        {
            if(value > maxVal) maxVal = value;
        }
        
        vector<unordered_set<int>> candidates(maxVal, unordered_set<int>());
        
        for(int i = 0; i < nums.size(); i++)
        {
            for(int j = 0; j < maxVal; j++)
            {
                if(candidates[j].find(nums[i]) == candidates[j].end())
                {
                    candidates[j].insert(nums[i]);
                    break;
                }
            }
        }
        
        vector<vector<int>> ans;
        
        for(int i = 0; i < candidates.size(); i++)
        {
            vector<int> curt;
            for(auto& num : candidates[i])
            {
                curt.push_back(num);
            }
            ans.push_back(curt);
        }
        
        return ans;
    }
};