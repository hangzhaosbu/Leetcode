class Solution:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        ans = []
        
        for j in range(len(matrix[0])):
            temp = []
            for i in range(len(matrix)):
                temp.append(matrix[i][j])
            ans.append(temp)
        
        return ans