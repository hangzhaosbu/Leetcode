class Solution {
    private int distance(int x1, int y1, int x2, int y2)
    {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
    
    public int[][] kClosest(int[][] points, int k)
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b)
            {
                return b[0] - a[0];
            }
        });
        
        for(int[] point : points)
        {
            int x = point[0], y = point[1];
            int dis = distance(x, y, 0, 0);
            
            pq.offer(new int[]{dis, x, y});
            
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        
        int[][] result = new int[k][2];
        int p = 0;
        
        
        while(!pq.isEmpty())
        {
            int[] curt = pq.poll();
            
            result[p][0] = curt[1];
            result[p++][1] = curt[2];
        }
        
        return result;
    }
}