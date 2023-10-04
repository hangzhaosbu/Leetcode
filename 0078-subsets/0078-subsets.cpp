class Solution {
public:
    void dfs(int start, vector<int>& nums, vector<int>& result, vector<vector<int>>& results, int k)
    {
        if(result.size() == k)
        {
            results.push_back(result);
            return;
        }
        
        for(int i = start; i < nums.size(); i++)
        {
            result.push_back(nums[i]);
            dfs(i + 1, nums, result, results, k);
            result.pop_back();
        }
    }
    
    vector<vector<int>> subsets(vector<int>& nums)
    {
        vector<vector<int>> results;
        vector<int> result;
        
        for(int k = 0; k <= nums.size(); k++)
            dfs(0, nums, result, results, k);
        return results;
    }
};