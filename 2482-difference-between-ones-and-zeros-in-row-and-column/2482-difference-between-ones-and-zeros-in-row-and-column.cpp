class Solution {
public:
    vector<vector<int>> onesMinusZeros(vector<vector<int>>& grid) {
        int n=grid.size(),m=grid[0].size();
        vector<vector<int>>ans(n,vector<int>(m,0));
        unordered_map<string,vector<int>>mp;

        for(int i=0;i<n;i++){
            int ones=0,zeros=0;
            for(int j=0;j<m;j++){
                if(grid[i][j])ones++;
                else
                    zeros++;
            }
            mp[to_string(i) + "r"].push_back(zeros);
            mp[to_string(i) + "r"].push_back(ones);
        }

        for(int i=0;i<m;i++){
            int ones=0,zeros=0;
            for(int j=0;j<n;j++){
                if(grid[j][i])ones++;
                else
                    zeros++;
            }
            mp[to_string(i) + "c"].push_back(zeros);
            mp[to_string(i) + "c"].push_back(ones);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j] = mp[to_string(i) + "r"][1] + mp[to_string(j) + "c"][1]
                        - mp[to_string(i) + "r"][0] - mp[to_string(j) + "c"][0];
            }
        }
        return ans;
    }
};