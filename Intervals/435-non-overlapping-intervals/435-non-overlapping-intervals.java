class Solution {
    public int eraseOverlapIntervals(int[][] intervals)
    {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b)
            {
                return a[1] - b[1];
            }
        });
        
        int i = 0, count = 0, N = intervals.length;
        
        while(i < N)
        {
            int j = i + 1;
            count++;
            
            
            while(j < N && intervals[j][0] < intervals[i][1])
            {
                j++;
            }
            i = j;
        }
        
        return N - count;
    }
}