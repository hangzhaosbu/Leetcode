class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        directions = [[0,1],[0,-1],[1,0],[-1,0]]
        dim = [len(board), len(board[0])]
        
        def recur(x, y, curt, pos):
            if len(curt) >= len(word):
                if curt == word:
                    return True
                return False
            
            ret = False
            
            for direction in directions:
                newx = x + direction[0]
                newy = y + direction[1]
                
                if newx < 0 or newx >= dim[0] or newy < 0 or newy >= dim[1]:
                    continue
                
                if pos < len(word) and board[newx][newy] == word[pos]:
                    temp = board[newx][newy]
                    board[newx][newy] = ""
                    ret |= recur(newx, newy, curt + word[pos], pos + 1)
                    board[newx][newy] = temp
            
            return ret
        
        
        for i in range(dim[0]):
            for j in range(dim[1]):
                if board[i][j] == word[0]:
                    temp = board[i][j]
                    board[i][j] = ""
                    ret = False
                    ret |= recur(i, j, word[0], 1)
                    if ret:
                        return True
                    board[i][j] = temp
        return False