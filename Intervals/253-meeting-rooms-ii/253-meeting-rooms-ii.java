class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int N = intervals.length;
        int[] starts = new int[N], ends = new int[N];
        int p = 0;
        
        for(int[] interval : intervals)
        {
            starts[p] = interval[0];
            ends[p++] = interval[1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int count = 0, result = 0;
        p = 0;
        
        for(int i = 0; i < N; i++)
        {
            int start = starts[i];
            count++;
            
            while(start >= ends[p])
            {
                p++;
                count--;
            }
            
            result = Math.max(result, count);
        }
        
        return result;
    }
}