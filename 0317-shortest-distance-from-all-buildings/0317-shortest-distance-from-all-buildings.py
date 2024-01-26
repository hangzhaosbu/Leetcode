class Solution:
    def shortestDistance(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        count = 0
        
        distance = [[0 for _ in range(n)] for _ in range(m)]
        reach = [[0 for _ in range(n)] for _ in range(m)]
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    count += 1
                    visited = [[False if grid[x][y] == 0 else True for y in range(n)] for x in range(m)]
                    
                    queue = [(i, j, 0)]
                    
                    while queue:
                        
                        size = len(queue)
                        
                        for _ in range(size):
                            
                            x, y, step = queue.pop(0)
                            
                            
                            
                            for direction in [[1,0],[-1,0],[0,-1],[0,1]]:
                                newx = x + direction[0]
                                newy = y + direction[1]
                                
                                if newx < 0 or newx >= m or newy < 0 or newy >= n:
                                    continue
                                
                                if not visited[newx][newy]:
                                    visited[newx][newy] = True
                                    reach[newx][newy] += 1
                                    distance[newx][newy] += step + 1
                                    queue.append((newx, newy, step + 1))
        
        ans = float("inf")
        """
        [0,2,1]
        [1,0,2]
        [0,1,0]
        
        
        [1,2,0]
        """
        
        for i in range(m):
            for j in range(n):
                if distance[i][j] != 0 and reach[i][j] == count:
                    ans = min(ans, distance[i][j])
        
        return ans if ans != float("inf") else -1