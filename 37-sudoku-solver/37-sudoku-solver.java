class Solution {
    
    private char[][] result;
    
    private void assign(char[][] board)
    {
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                this.result[i][j] = board[i][j];
            }
        }
        return;
    }
    
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
                assign(board);
            }
            return;
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
                board[i][j] = k;
                
                dfs(i + 1, j, M, N, rows, columns, cells, board);
                
                board[i][j] = '.';
                rows.get(i).remove(k);
                columns.get(j).remove(k);
                cells.get(i/3 * 3 + j/3).remove(k);
            }
        }
    }
    
    public void solveSudoku(char[][] board)
    {
        int M = board.length, N = board[0].length, cell = 0, row = 0, col = 0;
        this.result = new char[M][N];
        
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
                        cells.get(cell).add(board[i][j]);
                        columns.get(j).add(board[i][j]);
                        rows.get(i).add(board[i][j]);
                    }
                }
            }
            
            cell++;
        }
        
        dfs(0, 0, M, N, rows, columns, cells, board);
        
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                board[i][j] = result[i][j];
            }
        }
        return;
    }
}