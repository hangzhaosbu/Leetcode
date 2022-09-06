class Solution {
    public int mostBooked(int n, int[][] meetings)
    {
        Arrays.sort(meetings, new Comparator<>(){
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
        
        PriorityQueue<Integer> free = new PriorityQueue<>();
        PriorityQueue<long[]> busy = new PriorityQueue<>(Comparator.<long[]>comparingLong(o -> o[0]).thenComparingLong(o -> o[1]));
        
        int[] count = new int[n];
        int max = 0;
        
        for(int i = 0; i < n; ++i)
        {
            free.offer(i);
        }
        
        
        for(int i = 0; i < meetings.length; ++i)
        {
            int[] meeting = meetings[i];
            int start = meeting[0], end = meeting[1];
            
            while(!busy.isEmpty() && busy.peek()[0] <= start)
            {
                long[] item = busy.poll();
                free.offer((int) item[1]);
            }
            
            
            if(!free.isEmpty())
            {
                Integer idx = free.poll();
                count[idx] ++;
                max = Math.max(max, count[idx]);
                busy.offer(new long[]{(long) end, (long) idx});
            }
            else
            {
                long[] item = busy.poll();
                count[(int) item[1]] ++;
                max = Math.max(max, count[(int) item[1]]);
                busy.offer(new long[]{item[0] + (long) (end - start), item[1]});
            }
        }
        
        int ans = 0;
        for(int i = 0; i < n; ++i)
        {
            if(count[i] == max)
            {
                ans = i;
                break;
            }
        }
        
        return ans;
    }
}