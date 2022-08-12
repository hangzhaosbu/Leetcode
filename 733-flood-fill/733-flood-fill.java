class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color)
    {
        int same = image[sr][sc], N = image.length, M = image[0].length;
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int[][] visited = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        visited[sr][sc] = 1;
        
        while(!queue.isEmpty())
        {
            int[] position = queue.poll();
            int x = position[0], y = position[1];
            
            for(int[] direction : directions)
            {
                int new_x = x + direction[0];
                int new_y = y + direction[1];
                
                if(new_x < 0 || new_x >= N || new_y < 0 || new_y >= M)
                {
                    continue;
                }
                
                if(image[new_x][new_y] != same)
                {
                    continue;
                }
                
                if(visited[new_x][new_y] == 1)
                {
                    continue;
                }
                
                visited[new_x][new_y] = 1;
                image[new_x][new_y] = color;
                
                queue.offer(new int[]{new_x, new_y});
            }
        }
        
        return image;
    }
}