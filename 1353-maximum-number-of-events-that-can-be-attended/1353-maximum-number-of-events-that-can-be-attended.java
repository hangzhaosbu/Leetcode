class Solution {
    public int maxEvents(int[][] events)
    {
        Arrays.sort(events, new Comparator<>(){
            public int compare(int[] a, int[] b)
            {
                if(a[0] != b[0])
                {
                    return a[0] - b[0];
                }
                else
                {
                    return a[1] - b[1];
                }
            }
        });
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, N = events.length, count = 0;
        
        for(int days = 0; days <= 100000; ++days)
        {
            while(i < N && events[i][0] <= days)
            {
                pq.offer(events[i][1]);
                i++;
            }
            
            while(!pq.isEmpty() && pq.peek() < days)
            {
                pq.poll();
            }
            
            if(!pq.isEmpty())
            {
                count++;
                pq.poll();
            }
        }
        
        return count;
    }
}