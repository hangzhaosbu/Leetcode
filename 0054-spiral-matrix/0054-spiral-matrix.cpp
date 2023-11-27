class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int directions[4][2] = {{0,1},{1,0},{0,-1},{-1,0}};
        vector<int> ans;
        
        int N = matrix.size() * matrix[0].size();
        int x = 0, y = -1, d = 0;
        bool visited[matrix.size()][matrix[0].size()];
        
        for(int i = 0; i < matrix.size(); i++)
        {
            for(int j = 0; j < matrix[0].size(); j++)
            {
                visited[i][j] = false;
            }
        }
        
        while(ans.size() < N)
        {
            int newx = x + directions[d][0], newy = y + directions[d][1];
            
            if(newx < 0 || newx >= matrix.size() || newy < 0 || newy >= matrix[0].size() || visited[newx][newy])
            {
                d = (d + 1) % 4;
                newx = x + directions[d][0];
                newy = y + directions[d][1];
            }
            
            ans.push_back(matrix[newx][newy]);
            visited[newx][newy] = true;
            
            x = newx;
            y = newy;
            
        }
        
        return ans;
    }
};