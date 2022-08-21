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
        
        int result = 0;
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0; i < intervals.length; ++i)
        {
            if(!stack.isEmpty() && stack.peek()[1] > intervals[i][0])
            {
                result++;
            }
            else
            {
                stack.add(intervals[i]);
            }
        }
        
        return result;
    }
}