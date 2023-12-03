class Solution {
public:
    vector<vector<int>> generate(int N) {
        vector<vector<int>> ans;
        
        ans.push_back({1});
        if(N == 1) return ans;
        ans.push_back({1,1});
        
        for(int i = 0; i < N - 2; i++)
        {
            int m = ans.size() - 1;
            
            vector<int> curt;
            curt.push_back(1);
            for(int j = 1; j < ans.size(); j++)
            {
                curt.push_back(ans[m][j] + ans[m][j - 1]);
            }
            curt.push_back(1);
            
            ans.push_back(curt);
        }
        
        return ans;
    }
};