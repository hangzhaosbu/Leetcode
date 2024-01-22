class Solution:
    def minTotalDistance(self, grid: List[List[int]]) -> int:
        r = []
        c = []
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    r.append(i)
                    c.append(j)
        
        r.sort()
        c.sort()
        
        left, right = 0, len(r) - 1
        ans = 0
        
        while left < right:
            ans += c[right] - c[left]
            ans += r[right] - r[left]
            left += 1
            right -= 1
        
        return ans
            