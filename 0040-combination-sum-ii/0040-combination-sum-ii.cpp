class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target)
    {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> results;
        vector<int> result;
        
        dfs(0, 0, target, candidates, result, results);
        return results;
    }
    
    void dfs(int start, int sum, int target, vector<int>& candidates, vector<int>& result, vector<vector<int>>& results)
    {
        if(sum > target) return;
        if(sum == target)
        {
            results.push_back(result);
            return;
        }
        
        for(int i = start; i < candidates.size(); i++)
        {
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            result.push_back(candidates[i]);
            sum += candidates[i];
            dfs(i + 1, sum, target, candidates, result, results);
            sum -= candidates[i];
            result.pop_back();
        }
    }
};