class Solution {
public:
    
    int memo[40001];
    
    int twoToOne(pair<int,int> p, int m, int n)
    {
        return p.first * n + p.second;
    }
    
    int dfs(int curt, vector<vector<int>>& adj)
    {
        if(memo[curt] != 0)
        {
            return memo[curt];
        }
        vector<int> neighbors = adj[curt];
        
        for(auto neighbor : neighbors)
        {
            memo[curt] = max(memo[curt], dfs(neighbor, adj));
        }
        
        
        return ++memo[curt];
    }
    
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int m = matrix.size(), n = matrix[0].size();
        
        vector<vector<int>> adj(m * n, vector<int>(0));
        unordered_map<int,int> map;
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                map[twoToOne({i, j}, m, n)] = 0;
            }
        }
        
        int directions[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int x = 0; x < m; x++)
        {
            for(int y = 0; y < n; y++)
            {
                
                for(auto& direction : directions)
                {
                    int newx = x + direction[0];
                    int newy = y + direction[1];
                    
                    if(newx < 0 || newx >= m || newy < 0 || newy >= n)
                    {
                        continue;
                    }
                    
                    if(matrix[newx][newy] <= matrix[x][y]) 
                    {
                        continue;
                    }
                    
                    int curt = twoToOne({x, y}, m, n);
                    int next = twoToOne({newx, newy}, m, n);
                    
                    adj[curt].push_back(next);
                    map[next]++;
                }
            }
        }
        
        int ans = 0;
        
        for(auto& [key, value] : map)
        {
            if(value == 0)
                ans = max(ans, dfs(key, adj));
        }
        
        return ans;
    }
};