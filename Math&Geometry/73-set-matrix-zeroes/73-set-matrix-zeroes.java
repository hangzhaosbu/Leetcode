class Solution {
    public void setZeroes(int[][] matrix) {
        boolean first_row = false;
        int N = matrix.length, M = matrix[0].length;
        
        for(int i = 0; i < N; ++i)
        {
            if(matrix[i][0] == 0)
            {
                first_row = true;
            }
        }
        
        for(int j = 0; j < M; ++j)
        {
            if(matrix[0][j] == 0)
            {
                matrix[0][0] = 0;
            }
        }
        
        for(int i = 1; i < N; ++i)
        {
            for(int j = 1; j < M; ++j)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < N; ++i)
        {
            for(int j = 1; j < M; ++j)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int j = 0; j < M; ++j)
        {
            if(matrix[0][0] == 0)
            {
                matrix[0][j] = 0;
            }
        }
        
        if(first_row)
        {
            for(int i = 0; i < N; ++i)
            {
                matrix[i][0] = 0;
            }
        }
    }
}