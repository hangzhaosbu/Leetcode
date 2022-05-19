class Solution {
    
    int result = Integer.MIN_VALUE;
    
    private int dfs(int curt_x, int curt_y, int prev_x, int prev_y, int M, int N, HashMap<Integer, Integer> map, int[][] matrix)
    {
        if(curt_x < 0 || curt_x >= M || curt_y < 0 || curt_y >= N)
        {
            return 0;
        }
        
        if((prev_x == -1 && prev_y == -1) || (matrix[prev_x][prev_y] < matrix[curt_x][curt_y]))
        {
            if(map.get(curt_x * N + curt_y) >= 1)
            {
                return map.get(curt_x * N + curt_y);
            }

            int up    = dfs(curt_x - 1, curt_y, curt_x, curt_y, M, N, map, matrix);
            int down  = dfs(curt_x + 1, curt_y, curt_x, curt_y, M, N, map, matrix);
            int left  = dfs(curt_x, curt_y - 1, curt_x, curt_y, M, N, map, matrix);
            int right = dfs(curt_x, curt_y + 1, curt_x, curt_y, M, N, map, matrix);

            map.put(curt_x * N + curt_y, Math.max(Math.max(up, down), Math.max(left, right)) + 1);
            result = Math.max(result, map.get(curt_x * N + curt_y));
            
            return map.get(curt_x * N + curt_y);
        }
        else
        {
            return 0;
        }
        
    }
    
    public int longestIncreasingPath(int[][] matrix) 
    {
        int M = matrix.length, N = matrix[0].length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < M; ++i)
        {
            for(int j = 0; j < N; ++j)
            {
                map.put(i * N + j, -2);
            }
        }
        
        for(int i = 0; i < M; ++i)
        {
            for(int j = 0; j < N; ++j)
            {
                dfs(i, j, -1, -1, M, N, map, matrix);
            }
        }
        
        return result;
    }
}