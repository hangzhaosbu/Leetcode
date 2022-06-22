class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval)
    {
        /*
            |   |
              |   |
        */
        TreeMap<Integer, Integer> treemap = new TreeMap<Integer, Integer>();
        
        for(int[] interval : intervals)
        {
            treemap.put(interval[0], interval[1]);
        }
        
        int start = newInterval[0], end = newInterval[1];
        int left = start, right = end;
        
        Map.Entry<Integer, Integer> floor = treemap.floorEntry(left);
        if(floor != null){
            
            if(floor.getValue() >= end)
            {
                int[][] result = new int[treemap.size()][2];
                int p = 0;

                while(!treemap.isEmpty())
                {
                    result[p++] = new int[]{treemap.firstEntry().getKey(), treemap.firstEntry().getValue()};
                    treemap.pollFirstEntry();
                }
                
                return result;
            }
            
            if(floor.getValue() >= start){
                treemap.remove(floor.getKey());
                start = floor.getKey();
            }
        }
        
        
        Map.Entry<Integer, Integer> ceiling = treemap.ceilingEntry(left);
        while(ceiling != null && ceiling.getKey() <= end){
            treemap.remove(ceiling.getKey());
            end = Math.max(end, ceiling.getValue());
            ceiling = treemap.ceilingEntry(left);
        }
        
        treemap.put(start, end);
        
        int[][] result = new int[treemap.size()][2];
        int p = 0;
        
        while(!treemap.isEmpty())
        {
            result[p++] = new int[]{treemap.firstEntry().getKey(), treemap.firstEntry().getValue()};
            treemap.pollFirstEntry();
        }
        
        return result;
    }
}