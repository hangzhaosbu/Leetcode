class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> results;
        vector<int> result;
        
        dfs(1, k, n, result, results);
        return results;
    }
    
    void dfs(int start, int k, int n, vector<int>& result, vector<vector<int>>& results)
    {
        if(result.size() > k) return;
        if(result.size() == k)
        {
            results.push_back(result);
            return;
        }
        
        for(int i = start; i <= n; i++)
        {
            result.push_back(i);
            dfs(i + 1, k, n, result, results);
            result.pop_back();
        }
    }
};