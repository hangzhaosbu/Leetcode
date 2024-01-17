class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        direction = 1
        ans = []
        i = 0
        m, n = len(mat), len(mat[0])
        r, c = 0, 0
        
        while i < m * n:
            
            ans.append(mat[r][c])
            
            if direction == 1:
                if c == n - 1:
                    r += 1
                    direction = -1
                elif r == 0:
                    c += 1
                    direction = -1
                else:
                    c += 1
                    r -= 1
                    
            else:
                if r == len(mat) - 1:
                    c += 1
                    direction = 1
                elif c == 0:
                    r += 1
                    direction = 1
                else:
                    c -= 1
                    r += 1
            i += 1
        
        
        return ans