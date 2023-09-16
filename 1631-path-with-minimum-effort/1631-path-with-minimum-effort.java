class Pair{
    int x;  int y;   int diff;
    Pair(int diff,int x,int y){
            this.diff=diff; this.x=x;  this.y=y;  
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {

        int row =heights.length;
        int col =heights[0].length;
 
        int [][] vis = new int [row][col];
         for (int i = 0; i < row; i++) 
         Arrays.fill(vis[i], Integer.MAX_VALUE);

        PriorityQueue<Pair> qp = new PriorityQueue<Pair>((x,y) -> x.diff - y.diff);
        qp.offer(new Pair(0,0,0));
        vis[0][0]=0;
       
        int [][] dirc = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!qp.isEmpty()){

            Pair p=qp.poll();

            int disf = p.diff;
            int xAxis=p.x;
            int yAxis=p.y;

            if(xAxis==row-1 && yAxis==col-1)
            return disf;
              
              
            
          for(int ar[]:dirc){

              int x = xAxis+ar[0];
              int y = yAxis+ar[1];

              if(x<0||x>=row||y<0||y>=col)
              continue;

               int ndiff=Math.abs(heights[x][y]- heights[xAxis][yAxis]);
               ndiff=Math.max(disf,ndiff);

               if(vis[x][y] > ndiff){
               vis[x][y] = ndiff;
               qp.offer(new Pair(ndiff,x,y));
               }
          }

        }

         return 0; 
    }
}