class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> results;
        set<vector<int>> used;
        sort(nums.begin(), nums.end());
        int n = nums.size();
        for(int i = pow(2, n); i < pow(2, n + 1); i++)
        {
            string s = bitset<11>(i).to_string().substr(11 - n);
            vector<int> result;
            
            for(int i = 0; i < n; i++)
            {
                if(s[i] == '1') result.push_back(nums[i]);
            }
            if(used.find(result) == used.end())
            {
                results.push_back(result);
                used.insert(result);
            }
        }
        
        return results;
    }
};