class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        buffer = []
        
        for j in range(len(matrix[0])):
            buffer.append(matrix[0][j])
            
        
        for i in range(1, len(matrix)):
            for j in range(len(matrix[0])):
                if j > 0 and matrix[i][j] != buffer[j - 1]:
                    return False
            
            buffer.pop()
            buffer.insert(0, matrix[i][0])
        
        return True