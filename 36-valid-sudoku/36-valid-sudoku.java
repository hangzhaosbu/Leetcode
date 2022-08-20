class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
        for(int i = 0; i < 9; i += 3)
        {
            for(int j = 0; j < 9; j += 3)
            {
                HashSet<Character> hashset = new HashSet<>();
                for(int p = 0; p < 3; p++)
                {
                    for(int q = 0; q < 3; q++)
                    {
                        if(board[i + p][j + q] == '.') continue;
                        
                        if(!hashset.contains(board[i + p][j + q]))
                        {
                            hashset.add(board[i + p][j + q]);
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
            }
        }
        
        // Each row must contain the digits 1-9 without repetition.
        for(int i = 0; i < 9; ++i)
        {
            HashSet<Character> hashset = new HashSet<>();
            for(int j = 0; j < 9; ++j)
            {
                if(board[i][j] == '.') continue;
                
                if(!hashset.contains(board[i][j]))
                {
                    hashset.add(board[i][j]);
                }
                else
                {
                    return false;
                }
            }
        }
        
        // Each column must contain the digits 1-9 without repetition.
        for(int j = 0; j < 9; ++j)
        {
            HashSet<Character> hashset = new HashSet<>();
            for(int i = 0; i < 9; ++i)
            {
                if(board[i][j] == '.') continue;
                
                if(!hashset.contains(board[i][j]))
                {
                    hashset.add(board[i][j]);
                }
                else
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}