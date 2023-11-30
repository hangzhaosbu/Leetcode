class Solution {
   
    char[][] ans = new char[9][9];
    public void solveSudoku(char[][] board) {
        HashMap<Integer, ArrayList<Character>> row = new HashMap<>();
        HashMap<Integer, ArrayList<Character>> col = new HashMap<>();
        HashMap<Integer, ArrayList<Character>> cube = new HashMap<>();
       
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
               if (!row.containsKey(i)){
                    row.put(i, new ArrayList<>());
                }
                if (!col.containsKey(j)){
                    col.put(j, new ArrayList<>());
                }
                if (!cube.containsKey((i/3)*9 + (j/3))){
                    cube.put((i/3)*9 + (j/3), new ArrayList<>());
                }

                if (board[i][j] != '.'){
                    row.get(i).add(board[i][j]);
                    col.get(j).add(board[i][j]);
                    cube.get((i/3)*9 + (j/3)).add(board[i][j]);  
                }
               


            }
        }

       

        baktrak(0,0,board, new char[9][9], row, col, cube);
        for (int i= 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                board[i][j] = ans[i][j];
            }
        }
    }

    public void baktrak(int iStart, int jStart, char[][] board, char[][] curt, HashMap<Integer, ArrayList<Character>> row, HashMap<Integer, ArrayList<Character>> col, HashMap<Integer, ArrayList<Character>> cube){
        if (iStart == 9 && jStart == 0){
           
            for (int i= 0; i < 9; i++){
                for (int j = 0; j < 9; j++){
                    ans[i][j] = curt[i][j];
                }
            }
           
            return;
        }


       
        if (board[iStart][jStart] == '.'){
            for (int k = 1; k <= 9; k++){
                if (!row.containsKey(iStart)){
                    row.put(iStart, new ArrayList<>());
                }
                if (!col.containsKey(jStart)){
                    col.put(jStart, new ArrayList<>());
                }
                if (!cube.containsKey((iStart/3)*9 + (jStart/3))){
                    cube.put((iStart/3)*9 + (jStart/3), new ArrayList<>());
                }


                if (row.get(iStart).contains((char)(k+'0'))) continue;
                if (col.get(jStart).contains((char)(k+'0'))) continue;
                if (cube.get((iStart/3)*9 + (jStart/3)).contains((char)(k+'0'))) continue;

                curt[iStart][jStart] = (char)(k+'0');
                row.get(iStart).add((char)(k+'0'));
                col.get(jStart).add((char)(k+'0'));
                cube.get((iStart/3)*9 + (jStart/3)).add((char)(k+'0'));
                if (jStart < 8){
                    baktrak(iStart, jStart+1, board, curt, row, col, cube);
                }
                else{
                     baktrak(iStart+1, 0, board, curt, row, col, cube);
                }
                curt[iStart][jStart] = '.';    
                row.get(iStart).remove(row.get(iStart).size() - 1);
                col.get(jStart).remove(col.get(jStart).size() - 1);
                cube.get((iStart/3)*9 + (jStart/3)).remove(cube.get((iStart/3)*9 + (jStart/3)).size() - 1);
                       
            }

           
        }
        else{
            
            curt[iStart][jStart] = board[iStart][jStart];
       

       
            if (jStart < 8){
                baktrak(iStart, jStart+1, board, curt, row, col, cube);
            }
            else{
                baktrak(iStart+1, 0, board, curt, row, col, cube);
            } 
            
            
        }
         
               
           
    }

}