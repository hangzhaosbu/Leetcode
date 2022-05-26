class Solution {
    
    boolean result = false;
    
    private boolean valid(HashMap<Integer, HashSet<Character>> rows, HashMap<Integer, HashSet<Character>> columns, HashMap<Integer, HashSet<Character>> cells)
    {
        for(int i = 0; i < 9; i++)
        {
            if(rows.get(i).size() != 9 || columns.get(i).size() != 9 || cells.get(i).size() != 9)
            {
                return false;
            }
        }
        
        return true;
    }
    
    private void dfs(int i, int j, int M, int N, HashMap<Integer, HashSet<Character>> rows, HashMap<Integer, HashSet<Character>> columns, HashMap<Integer, HashSet<Character>> cells, char[][] board)
    {
        if(i == 0 && j == N)
        {
            if(valid(rows, columns, cells))
            {
                result = true;
                return;
            }
            else
            {
                return;
            }
        }
        
        if(i == M)
        {
            dfs(0, j + 1, M, N, rows, columns, cells, board);
            return;
        }
        
        // System.out.println(i + ", " + j);
        if(board[i][j] != '.')
        {
            dfs(i + 1, j, M, N, rows, columns, cells, board);
            return;
        }
        
        for(char k = '1'; k <= '9'; ++k)
        {
            if(!rows.get(i).contains(k) && !columns.get(j).contains(k) && !cells.get(i/3 * 3 + j/3).contains(k))
            {
                rows.get(i).add(k);
                columns.get(j).add(k);
                cells.get(i/3 * 3 + j/3).add(k);
                
                dfs(i + 1, j, M, N, rows, columns, cells, board);
                
                rows.get(i).remove(k);
                columns.get(j).remove(k);
                cells.get(i/3 * 3 + j/3).remove(k);
            }
        }
    }
    
    public boolean isValidSudoku(char[][] board)
    {
        
        /*
        [[".","8","7","6","5","4","3","2","1"],
         ["2",".",".",".",".",".",".",".","."],
         ["3",".",".",".",".",".",".",".","."],
         ["4",".",".",".",".",".",".",".","."],
         ["5",".",".",".",".",".",".",".","."],
         ["6",".",".",".",".",".",".",".","."],
         ["7",".",".",".",".",".",".",".","."],
         ["8",".",".",".",".",".",".",".","."],
         ["9",".",".",".",".",".",".",".","."]]
        */
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
        
        
//         for(int i = 0; i < 9; i++)
//         {
//             if(rows.get(i).size() == 0 && columns.get(i).size() == 0 && cells.get(i).size() == 0)
//             {
//                 return true;
//             }
//         }
        
        
//         dfs(0, 0, M, N, rows, columns, cells, board);
        return true;
    }
}