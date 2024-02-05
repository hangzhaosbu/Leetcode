class Solution:
    def resultGrid(self, image: List[List[int]], threshold: int) -> List[List[int]]:
        m, n = len(image), len(image[0])
        
        res = [[[0 for _ in range(2)] for _ in range(n)] for _ in range(m)]
        
        for i in range(m - 2):
            for j in range(n - 2):
                total = 0
                valid = True
                
                for ii in range(3):
                    for jj in range(3):
                        total += image[i + ii][j + jj]
                        
                        if ii > 0 and abs(image[i + ii][j + jj] - image[i + ii - 1][j + jj]) > threshold:
                            valid = False
                            break
                        
                        if jj > 0 and abs(image[i + ii][j + jj] - image[i + ii][j + jj - 1]) > threshold:
                            valid = False
                            break
                    
                    if not valid:
                        break
                
                if not valid:
                    continue
                
                total //= 9
                for ii in range(3):
                    for jj in range(3):
                        res[i + ii][j + jj][0] += total
                        res[i + ii][j + jj][1] += 1
                        
        
        for i in range(m):
            for j in range(n):
                if res[i][j][1] != 0:
                    image[i][j] = res[i][j][0]//res[i][j][1]
        
        return image