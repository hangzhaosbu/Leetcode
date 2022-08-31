class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights)
    {
        int N = heights.length, M = heights[0].length;
        boolean[][] pacific = new boolean[N][M];
        boolean[][] atlantic = new boolean[N][M];
        
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < heights.length; ++i)
        {
            queue.offer(new int[]{i, 0});
            pacific[i][0] = true;
        }
        
        for(int i = 0; i < heights[0].length; ++i)
        {
            queue.offer(new int[]{0, i});
            pacific[0][i] = true;
        }
        
        
        while(!queue.isEmpty())
        {
            int[] curt = queue.poll();
            int x = curt[0], y = curt[1];
            int curt_val = heights[x][y];
            
            for(int i = 0; i < 4; ++i)
            {
                int[] direction = directions[i];
                int new_x = x + direction[0], new_y = y + direction[1];
                
                if(new_x < 0 || new_x >= N || new_y < 0 || new_y >= M)
                {
                    continue;
                }
                
                int next_val = heights[new_x][new_y];
                if(next_val >= curt_val && pacific[new_x][new_y] == false)
                {
                    pacific[new_x][new_y] = true;
                    queue.offer(new int[]{new_x, new_y});
                }
            }
        }
        
        
        
        queue = new LinkedList<>();
        
        for(int i = 0; i < heights.length; ++i)
        {
            queue.offer(new int[]{i, M - 1});
            atlantic[i][M - 1] = true;
        }
        
        for(int i = 0; i < heights[0].length; ++i)
        {
            queue.offer(new int[]{N - 1, i});
            atlantic[N - 1][i] = true;
        }
        
        
        while(!queue.isEmpty())
        {
            int[] curt = queue.poll();
            int x = curt[0], y = curt[1];
            int curt_val = heights[x][y];
            
            for(int i = 0; i < 4; ++i)
            {
                int[] direction = directions[i];
                int new_x = x + direction[0], new_y = y + direction[1];
                
                if(new_x < 0 || new_x >= N || new_y < 0 || new_y >= M)
                {
                    continue;
                }
                
                int next_val = heights[new_x][new_y];
                if(next_val >= curt_val && atlantic[new_x][new_y] == false)
                {
                    atlantic[new_x][new_y] = true;
                    queue.offer(new int[]{new_x, new_y});
                }
            }
        }
        
        
        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < M; ++j)
            {
                if(pacific[i][j] == true && atlantic[i][j] == true)
                {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
}