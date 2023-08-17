class Pair{
    int row; int col; int level;
    public Pair(int row, int col, int level){
        this.row=row;
        this.col=col;
        this.level=level;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r=mat.length;
        int c= mat[0].length;
    //    int [][] ans = new int[r][c];
       Queue<Pair> q= new LinkedList<>();
       int [][] visited = new int [r][c];
       for(int i=0;i<r;i++){
           for(int j=0;j<c;j++){
               if(mat[i][j]==0){
                   q.offer(new Pair(i,j,0));
                   visited[i][j]=1;
               }
           }
       }
        int [] rowG= {-1,0,1,0};
        int [] colG={0,1,0,-1};
       while(!q.isEmpty()){
           Pair temp= q.poll();
           for(int i=0;i<4;i++){
                int x=temp.row+rowG[i];
                int y=temp.col+colG[i];
                if(x<r&&x>=0&&y>=0&&y<c&&visited[x][y]!=1){
                    q.offer(new Pair(x,y,temp.level+1));
                    visited[x][y]=1;
                    mat[x][y]=temp.level+1;
                }
            }

       }
       return mat;
    }
}