class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        
        #check row
        for col in range(n):
            curt = matrix[0][col]
            
            l = 1
            
            while l < m and col + l < n:
                temp = matrix[l][col + l]
                
                if temp != curt:
                    return False
                
                l+=1
                
        #check column
        for row in range(1, m):
            curt = matrix[row][0]
            
            l = 1
            
            while l < n and l + row < m:
                temp = matrix[row + l][l]
                
                if temp != curt:
                    return False
                
                l += 1
        return True