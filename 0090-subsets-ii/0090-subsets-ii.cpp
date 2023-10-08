class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        set<vector<int>> ans;
        sort(nums.begin(), nums.end());
        int n = nums.size();
        for(int i = pow(2, n); i < pow(2, n + 1); i++)
        {
            string s = bitset<10>(i).to_string().substr(10 - n);
            vector<int> result;
            for(int j = 0; j < n; j++) if(s[j] > '0') result.push_back(nums[j]);
            if(ans.find(result) == ans.end()) ans.insert(result);
        }
        return vector<vector<int>>(ans.begin(), ans.end());
    }
};