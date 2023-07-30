class Solution {
    public class Point implements Comparable<Point>{
        int x;
        int y;
        int d;

        public Point(int x, int y, int d){
            this.x=x;
            this.y=y;
            this.d=d;

        }

        public int compareTo(Point Point2){
            return -this.d + Point2.d;
           
        }

    }
   
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq=new PriorityQueue<>();
        int[][] ans=new int[k][2];

        for(int i = 0; i < points.length; i++){

            int d = (points[i][0] * points[i][0])     +    (points[i][1] * points[i][1]) ;
            pq.add(new Point(points[i][0],points[i][1],d));
            if(pq.size() > k)
            {
                pq.poll();
            }
        }


        for(int i = 0; i < k; i++){
            Point point=pq.remove();

            ans[i] = new int[]{point.x , point.y};
        }

        return ans;
    }
}
