class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        ans = [[] for _ in range(len(mat) + len(mat[0]) - 1)]
        
        for j in range(len(mat[0])):
            for i in range(len(mat)):
                ans[i + j].append(mat[i][j])
        
        
        
        ans = [x if y % 2 == 0 else x[::-1] for x, y in zip(ans, range(len(ans)))]
        ans = [xx for x in ans for xx in x]
        return ans