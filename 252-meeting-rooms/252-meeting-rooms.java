class Solution {
    public boolean canAttendMeetings(int[][] intervals)
    {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b)
            {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        int N = intervals.length;
        
        for(int i = 1; i < N; i++)
        {
            if(intervals[i][0] < intervals[i - 1][1])
            {
                return false;
            }
        }
        
        return true;
    }
}