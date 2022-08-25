class Solution {
    public boolean isValidSudoku(char[][] board)
    {
        
        // each 3*3 sub-matrix
        for(int i = 0; i < 9; i+=3)
        {
            for(int j = 0; j < 9; j+=3)
            {
                HashSet<Character> hashset = new HashSet<>();
                for(int p = 0; p < 3; ++p)
                {
                    for(int q = 0; q < 3; ++q)
                    {
                        if(board[p + i][q + j] == '.') continue;
                        
                        if(hashset.contains(board[p + i][q + j]))
                        {
                            return false;
                        }
                        else
                        {
                            hashset.add(board[p + i][q + j]);
                        }
                        
                    }
                }
            }
        }
        
        // each row
        for(int i = 0; i < 9; ++i)
        {
            HashSet<Character> hashset = new HashSet<>();
            for(int j = 0; j < 9; ++j)
            {
                if(board[i][j] == '.') continue;
                
                if(hashset.contains(board[i][j]))
                {
                    return false;
                }
                else
                {
                    hashset.add(board[i][j]);
                }
                
            }
        }
        
        // each column
        for(int j = 0; j < 9; ++j)
        {
            HashSet<Character> hashset = new HashSet<>();
            for(int i = 0; i < 9; ++i)
            {
                
                if(board[i][j] == '.') continue;
                
                if(hashset.contains(board[i][j]))
                {
                    return false;
                }

                else
                {
                    hashset.add(board[i][j]);
                }
            }
        }
        
        return true;
    }
}