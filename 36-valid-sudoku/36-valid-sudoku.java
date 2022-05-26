class Solution {
    
    public boolean isValidSudoku(char[][] board)
    {
        int M = board.length, N = board[0].length, cell = 0, row = 0, col = 0;
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> columns = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cells = new HashMap<>();
        
        for(int i = 0; i < 9; ++i)
        {
            rows.put(i, new HashSet<>());
            columns.put(i, new HashSet<>());
            cells.put(i, new HashSet<>());
        }
        
        for(int k = 0; k < 9; ++k)
        {
            for(int i = (k / 3) * 3; i < (k / 3) * 3 + 3; ++i)
            {
                for(int j = (k * 3 % 9); j < (k * 3 % 9) + 3; ++j)
                {
                    if(board[i][j] != '.')
                    {
                        if(!cells.get(cell).contains(board[i][j]))
                        {
                            cells.get(cell).add(board[i][j]);
                        }
                        else
                        {
                            return false;
                        }
                        
                        if(!columns.get(j).contains(board[i][j]))
                        {
                            columns.get(j).add(board[i][j]);
                        }
                        else
                        {
                            return false;
                        }
                        
                        if(!rows.get(i).contains(board[i][j]))
                        {
                            rows.get(i).add(board[i][j]);
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
            }
            
            cell++;
        }
        
        return true;
    }
}