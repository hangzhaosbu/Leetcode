class TicTacToe:

    def __init__(self, n: int):
        self.rows = {}
        self.cols = {}
        self.diagonal = {}
        self.n = n
        
        for i in range(n):
            
            self.rows[i] = [0, 0]
            self.cols[i] = [0, 0]
        
        self.diagonal[1] = [0, 0]
        self.diagonal[-1] = [0, 0]

    def move(self, row: int, col: int, player: int) -> int:
        player-=1
        
        self.rows[row][player]+=1
        self.cols[col][player]+=1
        
        if row == col:
            self.diagonal[1][player]+=1
        
        
        if row + col == self.n - 1:
            self.diagonal[-1][player]+=1
        
        
        if self.rows[row][player] == self.n or self.cols[col][player] == self.n or self.diagonal[1][player] == self.n or self.diagonal[-1][player] == self.n:
            return player + 1
        else:
            return 0
        

# Your TicTacToe object will be instantiated and called as such:
# obj = TicTacToe(n)
# param_1 = obj.move(row,col,player)