class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        m, n = len(heights), len(heights[0])
        directions = [[0,1],[0,-1],[1,0],[-1,0]]
        
        pacific = [[False for _ in range(n)] for _ in range(m)]
        atlantic = [[False for _ in range(n)] for _ in range(m)]
        
        queue = []
        
        for i in range(m): 
            queue.append((i, 0))
            pacific[i][0] = True
        for j in range(n): 
            queue.append((0, j))
            pacific[0][j] = True
        
        while queue:
            
            size = len(queue)
            for _ in range(size):
                x, y = queue.pop(0)
                for direction in directions:
                    newx, newy = x + direction[0], y + direction[1]

                    if newx < 0 or newx >= m or newy < 0 or newy >= n:
                        continue

                    if heights[newx][newy] >= heights[x][y] and not pacific[newx][newy]:
                        queue.append((newx, newy))
                        pacific[newx][newy] = True
                    
                    
        
        queue = []
        
        for i in range(m): 
            queue.append((i, n - 1))
            atlantic[i][n - 1] = True
        for j in range(n): 
            queue.append((m - 1, j))
            atlantic[m - 1][j] = True
        
        while queue:
            
            size = len(queue)
            for _ in range(size):
                x, y = queue.pop(0)
                for direction in directions:
                    newx, newy = x + direction[0], y + direction[1]

                    if newx < 0 or newx >= m or newy < 0 or newy >= n:
                        continue

                    if heights[newx][newy] >= heights[x][y] and not atlantic[newx][newy]:
                        queue.append((newx, newy))
                        atlantic[newx][newy] = True
                    
                    
        ret = []
        for i in range(m):
            for j in range(n):
                if pacific[i][j] and atlantic[i][j]:
                    ret.append([i, j])
        
        return ret
                