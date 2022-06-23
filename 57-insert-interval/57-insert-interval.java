class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        
        for(int[] interval : intervals)
        {
            if(interval[1] < newInterval[0])
            {
                result.add(interval);
            }
            else if(interval[0] > newInterval[1])
            {
                result.add(newInterval);
                newInterval = interval;
            }
            else
            {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        
        result.add(newInterval);
        return result.toArray(new int[result.size()][2]);
    }
}