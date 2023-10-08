class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums)
    {
        set<vector<int>> results;
        vector<int> result;
        int n = nums.size();
        bool used[n];
        
        for(int i = 0; i < n; i++) used[i] = false;
        
        sort(nums.begin(), nums.end());
        
        dfs(n, used, nums, result, results);
        return vector<vector<int>>(results.begin(), results.end());
    }
    
    void dfs(int n, bool used[], vector<int>& nums, vector<int>& result, set<vector<int>>& results)
    {
        if(result.size() == n && results.find(result) == results.end())
        {
            results.insert(result);
            return;
        }
        
        for(int i = 0; i < n; i++)
        {
            if(used[i]) continue;
            // if(i > 0 && nums[i] == nums[i - 1]) continue;
            
            result.push_back(nums[i]);
            used[i] = true;
            dfs(n, used, nums, result, results);
            used[i] = false;
            result.pop_back();
        }
    }
};