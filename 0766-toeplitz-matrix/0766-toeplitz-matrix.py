class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        
        for row in range(len(matrix)):
            
            count = 1
            curt = []
            for col in range(len(matrix[0])):
                curt.append(matrix[row][col])
            
            
            for i in range(row + 1, len(matrix)):
                for j in range(count, len(matrix[0])):
                    if curt[j - count] != matrix[i][j]:
                        return False
                count+=1
        return True