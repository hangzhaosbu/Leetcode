class Solution {
    public int minFallingPathSum(int[][] matrix) {
        /*
        [[-73,61,43,-48,-36],
         [3,  30,27, 57, 10],
         [96,-76,84, 59,-15],
         [5, -49,76, 31, -7],
         [97 ,91,61,-46, 67]]
        
        
        
        -73 61 43 -48 -36 
        -45 30 27 -16  10 
        80 -76 84  14 -15 
        5  -64 76  31 -83 
        97   8 61 -46   3 
        
        */
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
                else if(i - 1 >= 0)
                {
                    matrix[i][j] = matrix[i][j] + first;
                }
                
                if(i == M - 1)
                {
                    result = Math.min(result, matrix[i][j]);
                }
            }
        }
        
        // for(int[] a : matrix)
        //     for(int b : a)
        //         System.out.print(b + " ");
        
        return result;
    }
}