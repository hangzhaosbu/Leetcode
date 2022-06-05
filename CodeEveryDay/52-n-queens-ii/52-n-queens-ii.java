class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        if(n < 0){
            return 0;
        }
        
        helper(n, new ArrayList<Integer>());
        
        return count;
    }
    
    public void helper(int n, List<Integer> cols){
        
        if(cols.size() == n){
            count ++;
        }
        
        for(int colIndex = 0; colIndex < n; colIndex++){
            if(!isValid(cols, colIndex)) continue;
            
            cols.add(colIndex);
            helper(n, cols);
            cols.remove(cols.size() - 1);
        }
    }
    
    public boolean isValid(List<Integer> cols, int column){
        int row = cols.size();
        
        for(int rowIndex = 0; rowIndex < row; rowIndex++){
            
            if(cols.get(rowIndex) == column) return false;
            
            if(rowIndex + cols.get(rowIndex) == column + row) return false;
            
            if(rowIndex - cols.get(rowIndex) == row - column) return false;
        }
        
        return true;
    }
}