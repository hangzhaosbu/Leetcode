class Solution {
    public int maxEvents(int[][] events)
    {
        Arrays.sort(events, new Comparator<>(){
            public int compare(int[] a, int[] b)
            {
                if(a[0] != b[0]) return a[0] - b[0];
                else return a[1] - b[1];
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = events.length, i = 0, result = 0;
        
        for(int day = 1; day <= 100000; day++)
        {
            
            while(i < N && events[i][0] <= day)
            {
                pq.offer(events[i][1]);
                i++;
            }
            
            while(!pq.isEmpty() && pq.peek() < day)
            {
                pq.poll();
            }
            
            if(!pq.isEmpty())
            {
                pq.poll();
                result++;
            }
        }
        
        return result;
    }
}