class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval)
    {
        List<int[]> result = new ArrayList<>();
        
        for(int[] interval : intervals)
        {
            int start = interval[0], end = interval[1];
            if(end < newInterval[0])
            {
                result.add(interval);
            }
            else if(start > newInterval[1])
            {
                result.add(newInterval);
                newInterval = new int[]{start, end};
            }
            else
            {
                newInterval[0] = Math.min(newInterval[0], start);
                newInterval[1] = Math.max(newInterval[1], end);
            }
        }
        
        result.add(newInterval);
        return result.toArray(new int[result.size()][2]);
    }
}