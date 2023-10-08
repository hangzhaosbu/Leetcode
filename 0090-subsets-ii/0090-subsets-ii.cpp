class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums)
    {
        vector<vector<int>> results;
        vector<int> result;
        
        sort(nums.begin(), nums.end());
        
        int n = nums.size();
        
        for(int k = 0; k <= n; k++)
            dfs(0, k, nums, result, results);
        return results;
    }
    
    void dfs(int start, int length, vector<int>& nums, vector<int>& result, vector<vector<int>>& results)
    {
        if(result.size() == length)
        {
            results.push_back(result);
            return;
        }
        
        for(int i = start; i < nums.size(); i++)
        {
            if(i > start && nums[i] == nums[i - 1]) continue;
            result.push_back(nums[i]);
            dfs(i + 1, length, nums, result, results);
            result.pop_back();
        }
    }
};