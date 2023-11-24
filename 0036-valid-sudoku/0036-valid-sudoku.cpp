class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        for(int i = 0; i < board.size(); i++)
        {
            set<char> s;
            for(int j = 0; j < board[i].size(); j++)
            {
                if(board[i][j] != '.' && s.find(board[i][j]) != s.end()) return false;
                s.insert(board[i][j]);
            }
        }
        
        
        for(int j = 0; j < board[0].size(); j++)
        {
            set<char> s;
            for(int i = 0; i < board.size(); i++)
            {
                if(board[i][j] != '.' && s.find(board[i][j]) != s.end()) return false;
                s.insert(board[i][j]);
            }
        }
        
        
        for(int i = 0; i < board.size(); i+=3)
        {
            for(int j = 0; j < board[i].size(); j+=3)
            {
                set<char> s;
                for(int ki = 0; ki < 3; ki++)
                {
                    for(int kj = 0; kj < 3; kj++)
                    {
                        if(board[i + ki][j + kj] != '.' && s.find(board[i + ki][j + kj]) != s.end()) return false;
                        s.insert(board[i + ki][j + kj]);
                    }
                }
            }
        }
        
        return true;
    }
};