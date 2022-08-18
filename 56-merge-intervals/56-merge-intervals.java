class Solution {
    public int[][] merge(int[][] intervals)
    {
        TreeMap<Integer, Integer> treemap = new TreeMap<>();
        
        for(int i = 0; i < intervals.length; ++i)
        {
            int start = intervals[i][0], end = intervals[i][1];
            Map.Entry<Integer, Integer> ceiling = treemap.ceilingEntry(start);
            
            while(ceiling != null && ceiling.getKey() <= end)
            {
                start = Math.min(start, ceiling.getKey());
                end = Math.max(end, ceiling.getValue());
                treemap.remove(ceiling.getKey());
                ceiling = treemap.ceilingEntry(start);
            }
            
            Map.Entry<Integer, Integer> floor = treemap.floorEntry(end);
            
            while(floor != null && floor.getValue() >= start)
            {
                start = Math.min(start, floor.getKey());
                end = Math.max(end, floor.getValue());
                treemap.remove(floor.getKey());
                floor = treemap.floorEntry(end);
            }
            
            treemap.put(start, end);
        }
        
        int size = treemap.size();
        int[][] result = new int[size][2];
        int p = 0;
        
        while(size-- > 0)
        {
            result[p][0] = treemap.firstEntry().getKey();
            result[p][1] = treemap.firstEntry().getValue();
            p++;
            treemap.pollFirstEntry();
        }
        
        return result;
    }
}