class Solution {
public:
    vector<vector<char>> ans = vector<vector<char>>(9, vector<char>(9, '.'));
    
    void solveSudoku(vector<vector<char>>& board)
    {
        unordered_map<int, set<char>> rows;
        unordered_map<int, set<char>> columns;
        unordered_map<int, set<char>> cells;
        
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j] != '.')
                {
                    rows[i].insert(board[i][j]);
                    columns[j].insert(board[i][j]);
                    cells[(i/3) * 9 + (j/3)].insert(board[i][j]);
                }
            }
        }
        
        
        backtrack(0, 0, board.size(), board[0].size(), board, rows, columns, cells);
        
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                board[i][j] = ans[i][j];
            }
        }
    }
    
    void backtrack(int x, int y, int N, int M, vector<vector<char>>& board, unordered_map<int, set<char>>& rows, unordered_map<int, set<char>>& columns, unordered_map<int, set<char>>& cells)
    {
        if(x == N && y == 0)
        {
            
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                {
                    ans[i][j] = board[i][j];
                }
            }
            
            return;
        }
        
        if(board[x][y] == '.')
        {
            for(char a = '1'; a <= '9'; a++)
            {
                if(rows[x].find(a) == rows[x].end() && columns[y].find(a) == columns[y].end() && cells[(x/3) * 9 + (y/3)].find(a) == cells[(x/3) * 9 + (y/3)].end())
                {
                    board[x][y] = a;
                    
                    rows[x].insert(a);
                    columns[y].insert(a);
                    cells[(x/3) * 9 + (y/3)].insert(a);
                    
                    if(y < 8)
                    {
                        backtrack(x, y + 1, N, M, board, rows, columns, cells);
                    }
                    else
                    {
                        backtrack(x + 1, 0, N, M, board, rows, columns, cells);
                    }
                    
                    rows[x].erase(a);
                    columns[y].erase(a);
                    cells[(x/3) * 9 + (y/3)].erase(a);
                    
                    board[x][y] = '.';
                }
            }
        }
        else
        {
            if(y < 8)
            {
                backtrack(x, y + 1, N, M, board, rows, columns, cells);
            }
            else
            {
                backtrack(x + 1, 0, N, M, board, rows, columns, cells);
            }
        }
        
    }
};