class Solution {
public:
    int directions[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
    // bool ans = false;
    bool exist(vector<vector<char>>& board, string word)
    {
        int n = board.size(), m = board[0].size();
        vector<vector<bool>> visited(n, vector<bool>(m, false));
        bool ans = false;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(board[i][j] == word[0])
                {
                    visited[i][j] = true;
                    ans |= dfs(i, j, n, m, 1, word.length(), word.substr(0,1), word, board, visited);
                    visited[i][j] = false;
                }
            }
        }
        
        return ans;
    }
    
    bool dfs(int x, int y, int n, int m, int start, int size, string curt, string target, vector<vector<char>>& board, vector<vector<bool>>& visited)
    {
        if(start == size)
        {
            if(curt == target)
            {
                return true;
            }
            return false;
        }
        
        if(target.find(curt) != 0) return false;
        
        
        for(auto direction : directions)
        {
            int new_x = x + direction[0], new_y = y + direction[1];
            if(new_x < 0 || new_x >= n || new_y < 0 || new_y >= m) continue;
            if(visited[new_x][new_y]) continue;
            
            if(board[new_x][new_y] == target[start])
            {
                visited[new_x][new_y] = true;
                curt += board[new_x][new_y];
                if(dfs(new_x, new_y, n, m, start + 1, size, curt, target, board, visited)) return true;
                curt = curt.substr(0, curt.length() - 1);
                visited[new_x][new_y] = false;
            }
        }
        
        return false;
        
    }
};