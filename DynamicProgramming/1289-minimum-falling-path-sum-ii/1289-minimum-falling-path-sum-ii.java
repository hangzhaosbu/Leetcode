class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < M; ++i)
        {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int j = 0; j < N; ++j)
            {
                if(i - 1 >= 0)
                {
                    pq.offer(matrix[i - 1][j]);
                }
            }
            
            int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
            
            if(i - 1 >= 0)
            {
                first = pq.poll();
                second = pq.poll();
            }
            
            for(int j = 0; j < N; ++j)
            {
                if(i - 1 >= 0 && matrix[i - 1][j] == first)
                {
                    matrix[i][j] = matrix[i][j] + second;
                }
                else if(i - 1 >= 0) // if first use second else use first
                {
                    matrix[i][j] = matrix[i][j] + first;
                }
                
                if(i == M - 1)
                {
                    result = Math.min(result, matrix[i][j]);
                }
            }
        }

        return result;
    }
}