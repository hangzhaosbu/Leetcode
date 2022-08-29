class Solution {
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dist = new int[m][n];
        PriorityQueue<int []> q = new PriorityQueue<>((x,y) -> x[2] - y[2]);
        q.offer(new int[]{start[0], start[1], 0});
        
        while(!q.isEmpty()){
            
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dd = cur[2];
            
            if(visited[x][y]) continue;
            
            if(x == destination[0] && y == destination[1]) return dd;
            
            visited[x][y] = true;
            
            for(int[] direction : directions){
                
                int xx = x;
                int yy = y;
                int d = dd;
                
                while(isValid(maze, xx + direction[0], yy + direction[1], m, n)){
                    xx += direction[0];
                    yy += direction[1];
                    
                    d++;
                }
                
                
                if(dist[xx][yy] == 0 || dist[xx][yy] > d){
                    dist[xx][yy] = d;
                    q.offer(new int[]{xx, yy, d});
                }
            }
        }
        
        return -1;
    }
    
    public boolean isValid(int[][] maze, int x, int y, int row_len, int col_len){
        
        return x >= 0 && x < row_len && y >= 0 && y < col_len && maze[x][y] == 0;
    }
}