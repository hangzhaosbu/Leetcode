class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int N = intervals.length;
        int[][] candidates = new int[N + 1][2];
        
        for(int i = 0; i < N; i++)
        {
            candidates[i][0] = intervals[i][0];
            candidates[i][1] = intervals[i][1];
        }
        
        candidates[N][0] = newInterval[0];
        candidates[N][1] = newInterval[1];
        
        Arrays.sort(candidates, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);
            }
        });
        
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0; i < N + 1; i++)
        {
            int[] curt = candidates[i];
            int start = curt[0], end = curt[1];
            
            while(!stack.isEmpty() && stack.peek()[1] >= start)
            {
                int prev_start = stack.peek()[0], prev_end = stack.peek()[1];
                stack.pop();
                
                start = Math.min(start, prev_start);
                end = Math.max(end, prev_end);
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