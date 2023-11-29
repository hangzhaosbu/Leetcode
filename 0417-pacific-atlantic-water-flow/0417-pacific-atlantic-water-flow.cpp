class Solution {
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        int m = heights.size();
        int n = heights[0].size();
        
        vector<vector<int>> ans;
        
        int directions[4][2] = {{0,1},{0,-1},{1,0},{-1,0}};
        
        vector<vector<bool>> pacific(m, vector<bool>(n, false));
        vector<vector<bool>> atlantic(m, vector<bool>(n, false));
        
        queue<vector<int>> pacificq;
        queue<vector<int>> atlanticq;
        
        for(int i = 0; i < m; i++)
        {
            pacificq.push({i, 0});
            pacific[i][0] = true;
        }
        
        for(int j = 0; j < n; j++)
        {
            pacificq.push({0, j});
            pacific[0][j] = true;
        }
        
        while(!pacificq.empty())
        {
            vector<int> curt = pacificq.front();
            int x = curt[0], y = curt[1];
            pacificq.pop();
            
            for(auto & direction : directions)
            {
                int newx = x + direction[0];
                int newy = y + direction[1];
                
                if(newx < 0 || newx >= m || newy < 0 || newy >= n) continue;
                
                if(heights[newx][newy] < heights[x][y] || pacific[newx][newy]) continue;
                
                pacific[newx][newy] = true;
                pacificq.push({newx, newy});
            }
        }
        
        
        
        for(int i = 0; i < m; i++)
        {
            atlanticq.push({i, n - 1});
            atlantic[i][n - 1] = true;
        }
        
        for(int j = 0; j < n; j++)
        {
            atlanticq.push({m - 1, j});
            atlantic[m - 1][j] = true;
        }
        
        while(!atlanticq.empty())
        {
            vector<int> curt = atlanticq.front();
            int x = curt[0], y = curt[1];
            atlanticq.pop();
            
            for(auto & direction : directions)
            {
                int newx = x + direction[0];
                int newy = y + direction[1];
                
                if(newx < 0 || newx >= m || newy < 0 || newy >= n) continue;
                
                if(heights[newx][newy] < heights[x][y] || atlantic[newx][newy]) continue;
                
                atlantic[newx][newy] = true;
                atlanticq.push({newx, newy});
            }
        }
        
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(pacific[i][j] && atlantic[i][j])
                {
                    ans.push_back({i, j});
                }
            }
        }
        
        return ans;
    }
};