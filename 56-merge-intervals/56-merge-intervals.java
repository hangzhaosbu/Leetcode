class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
           public int compare(int[] a, int[] b)
           {
               return Integer.compare(a[0], b[0]);
           }
        });
        
        int N = intervals.length;
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0; i < N; ++i)
        {
            int start = intervals[i][0], end = intervals[i][1];
            
            while(!stack.isEmpty() && stack.peek()[1] >= start)
            {
                start = Math.min(start, stack.peek()[0]);
                end = Math.max(end, stack.peek()[1]);
                stack.pop();
            }
            
            stack.add(new int[]{start, end});
        }
        
        int[][] result = new int[stack.size()][2];
        int p = stack.size() - 1;
        
        while(!stack.isEmpty())
        {
            result[p--] = new int[]{stack.peek()[0], stack.peek()[1]};
            stack.pop();
        }
        
        return result;
    }
}