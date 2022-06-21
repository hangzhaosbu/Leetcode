class Solution {
    public List<Integer> spiralOrder(int[][] matrix)
    {
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        List<Integer> result = new ArrayList<>();
        int N = matrix.length, M = matrix[0].length;
        int p = 1, count = N * M, d = 0;
        int x = 0, y = 0;
        result.add(matrix[0][0]);
        matrix[x][y] = -101;
        
        while (p < count)
        {
            x = x + directions[d%4][0];
            y = y + directions[d%4][1];
            if(valid(x, y, N, M) && matrix[x][y] != -101)
            {
                result.add(matrix[x][y]);
                matrix[x][y] = -101;
                p++;
            }
            else
            {
                x = x - directions[d%4][0];
                y = y - directions[d%4][1];
                d++;
            }
        }
        return result;
    }
    
    private boolean valid(int x, int y, int N, int M)
    {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}