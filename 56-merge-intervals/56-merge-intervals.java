class Solution {
    public int[][] merge(int[][] intervals) {
        Stack<int[]> stack = new Stack<>();
        Arrays.sort(intervals, new Comparator<>(){
            public int compare(int[] a, int[] b)
            {
                return a[1] != b[1]? a[1] - b[1]: a[0] - b[0];
            }
        });
        
        for(int i = 0; i < intervals.length; ++i)
        {
            while(!stack.isEmpty() && stack.peek()[1] >= intervals[i][0])
            {
                int[] top = stack.pop();

                intervals[i][0] = Math.min(intervals[i][0], top[0]);
                intervals[i][1] = Math.max(intervals[i][1], top[1]);
            }
            
            stack.add(intervals[i]);
        }
        
        int[][] result = new int[stack.size()][2];
        int p = stack.size() - 1;
        
        while(!stack.isEmpty())
        {
            result[p--] = stack.pop();
        }
        
        return result;
    }
}