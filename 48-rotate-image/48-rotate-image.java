class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length, M = matrix[0].length;
        
        for(int i = 0; i < N; i++)
        {
            for(int j = i; j < M; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < M/2; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][M - j - 1];
                matrix[i][M - j - 1] = temp;
            }
        }
    }
}