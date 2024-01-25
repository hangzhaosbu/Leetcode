class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        if grid[0][0] == 1 or grid[-1][-1] == 1:
            return -1
        
        directions = [[1,0],[-1,0],[0,1],[0,-1],[1,1],[1,-1],[-1,1],[-1,-1]]
        visited = [[False for _ in range(len(grid[0]))] for _ in range(len(grid))]
        queue = [(0, 0, 1)]
        visited[0][0] = True
        
        while queue:
            size = len(queue)
            
            for _ in range(size):
                
                x, y, step = queue.pop(0)
                
                if x == len(grid) - 1 and y == len(grid[0]) - 1:
                    return step
                
                for direction in directions:
                    newx, newy = x + direction[0], y + direction[1]
                    
                    if newx < 0 or newx >= len(grid) or newy < 0 or newy >= len(grid[0]):
                        continue
                    
                    if not visited[newx][newy] and grid[newx][newy] == 0:
                        visited[newx][newy] = True
                        queue.append((newx, newy, step + 1))
        
        return -1