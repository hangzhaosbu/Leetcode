class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row = {}
        column = {}
        cell = {}
        
        
        m, n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                num = board[i][j]
                if num == '.':
                    continue
                
                if i not in row:
                    row[i] = []
                    
                if j not in column:
                    column[j] = []
                
                
                idx = (i//3)*3+(j//3)
                
                if idx not in cell:
                    cell[idx] = []
                
                if num in row[i] or num in column[j] or num in cell[idx]:
                    # print(i, j)
                    # print(num, row, column, cell)
                    return False
                
                row[i].append(num)
                column[j].append(num)
                cell[idx].append(num)
        
        return True