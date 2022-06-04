class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> results = new ArrayList<>();
        
        if(n < 0) return results;
        
        helper(n, new ArrayList<Integer>(), results);
        
        return results;
    }
    
    public void helper(int n, List<Integer> cols, List<List<String>> results){
        
        if(cols.size() == n){
            results.add(drawChessBoard(cols));
        }
        
        for(int colIndex = 0; colIndex < n; colIndex ++){
            if(!isValid(cols, colIndex)){
                continue;
            }
            
            cols.add(colIndex);
            
            helper(n, cols, results);
            
            cols.remove(cols.size() - 1);
        }
    }
    
    public boolean isValid(List<Integer> cols, int column){
        int row = cols.size();
        
        for(int rowIndex = 0; rowIndex < row; rowIndex++){
            if(cols.get(rowIndex) == column){
                return false;
            }
            
            if(rowIndex + cols.get(rowIndex) == column + row){
                return false;
            }
            
            if(rowIndex - cols.get(rowIndex) == row - column){
                return false;
            }
        }
        
        return true;
    }
    
    public List<String> drawChessBoard(List<Integer> cols){
        List<String> chess = new ArrayList<>();
        for(int i = 0; i < cols.size(); i++){
            StringBuilder s = new StringBuilder();
            for(int j = 0; j < cols.size(); j++){
                if(j == cols.get(i)){
                    s.append("Q");
                }
                else{
                    s.append(".");
                }
            }
            
            chess.add(s.toString());
        }
        return chess;
    }
}