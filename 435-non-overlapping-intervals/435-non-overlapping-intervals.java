class Solution {
    public int eraseOverlapIntervals(int[][] intervals)
    {
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
        
        int count = 0;
        
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0; i < intervals.length; i++)
        {
            int start = intervals[i][0], end = intervals[i][1];
            
            if(stack.isEmpty() || (!stack.isEmpty() && stack.peek()[1] <= start))
            {
                stack.push(intervals[i]);
            }
            else
            {
                count++;
            }
        }
        
        return count;
    }
}