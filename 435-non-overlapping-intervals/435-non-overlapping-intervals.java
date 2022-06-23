class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b)
            {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        int i = 0, N = intervals.length;
        int count = 0, j = 0;
        
        while(i < N)
        {
            count++;
            j = i + 1;
            
            while(j < N && intervals[j][0] < intervals[i][1])
            {
                j++;
            }
            
            i = j;
        }
        
        return N - count;
    }
}