class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights)
    {
        HashSet<Integer> pacific = new HashSet<>();
        HashSet<Integer> atlantic = new HashSet<>();
        int N = heights.length, M = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < N; ++i)
        {
            dfs(i, 0, pacific, heights, heights[i][0]);
            dfs(i, M - 1, atlantic, heights, heights[i][M - 1]);
        }
        
        for(int j = 0; j < M; ++j)
        {
            dfs(0, j, pacific, heights, heights[0][j]);
            dfs(N - 1, j, atlantic, heights, heights[N - 1][j]);
        }
        
        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < M; ++j)
            {
                if(pacific.contains(i * M + j) && atlantic.contains(i * M + j))
                {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int x, int y, HashSet<Integer> visited, int[][] heights, int prevHeight)
    {
        int N = heights.length, M = heights[0].length;
        if(x < 0 || x >= N || y < 0 || y >= M || visited.contains(x * M + y) || heights[x][y] < prevHeight)
        {
            return;
        }
        
        visited.add(x * M + y);
        dfs(x + 1, y, visited, heights, heights[x][y]);
        dfs(x - 1, y, visited, heights, heights[x][y]);
        dfs(x, y + 1, visited, heights, heights[x][y]);
        dfs(x, y - 1, visited, heights, heights[x][y]);
    }
}