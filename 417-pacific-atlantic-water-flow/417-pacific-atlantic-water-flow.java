class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights)
    {
        HashSet<Integer> pacific = new HashSet<>();
        HashSet<Integer> atlantic = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        int N = heights.length, M = heights[0].length;
        
        for(int j = 0; j < M; ++j)
        {
            dfs(0, j, N, M, pacific, heights, heights[0][j]);
            dfs(N - 1, j, N, M, atlantic, heights, heights[N - 1][j]);
        }
        
        for(int i = 0; i < N; ++i)
        {
            dfs(i, 0, N, M, pacific, heights, heights[i][0]);
            dfs(i, M - 1, N, M, atlantic, heights, heights[i][M - 1]);
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
    
    private void dfs(int x, int y, int N, int M, HashSet<Integer> hashset, int[][] heights, int prevHeight)
    {
        if(x < 0 || x >= N || y < 0 || y >= M || hashset.contains(x * M + y) || heights[x][y] < prevHeight)
        {
            return;
        }
        
        hashset.add(x * M + y);
        dfs(x + 1, y, N, M, hashset, heights, heights[x][y]);
        dfs(x - 1, y, N, M, hashset, heights, heights[x][y]);
        dfs(x, y + 1, N, M, hashset, heights, heights[x][y]);
        dfs(x, y - 1, N, M, hashset, heights, heights[x][y]);
    }
}