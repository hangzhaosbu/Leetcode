class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<>(){
            public int compare(int[] a, int[] b)
            {
                if(a[1] != b[1])
                {
                    return a[1] - b[1];
                }
                else
                {
                    return a[0] - b[0];
                }
            }
        });
        
        Stack<int[]> stack = new Stack<>();
        int count = 0;
        
        for(int i = 0; i < intervals.length; ++i)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if(!stack.isEmpty() && stack.peek()[1] > start)
            {
                count++;
            }
            else
            {
                stack.add(new int[]{start, end});
            }
        }
        
        return count;
    }
}