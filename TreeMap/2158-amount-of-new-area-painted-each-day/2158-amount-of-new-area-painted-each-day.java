class Solution {
    public int[] amountPainted(int[][] paint) {
        
        if(paint.length == 1)
        {
            return new int[]{paint[0][1] - paint[0][0]};
        }
        
        TreeMap<Integer, Integer> treemap = new TreeMap<Integer, Integer>();
        
        int N = paint.length;
        int[] result = new int[N];
        int idx = 0;
        
        for(int[] p : paint)
        {
            int start = p[0], end = p[1];
            int repeat = 0;
            
            Map.Entry<Integer, Integer> floor = treemap.floorEntry(start);
            if(floor != null)
            {
                if(floor.getValue() >= end)
                {
                    result[idx++] = 0;
                    continue;
                }
                    
                if(floor.getValue() > start)
                {
                    repeat += Math.min(end, floor.getValue()) - start;
                    treemap.remove(floor.getKey());
                    start = Math.min(start, floor.getKey());
                }
            }
            
            Map.Entry<Integer, Integer> ceiling = treemap.ceilingEntry(start);
            
            while(ceiling != null && ceiling.getKey() < end)
            {
                repeat += Math.min(end, ceiling.getValue()) - Math.max(start, ceiling.getKey());
                treemap.remove(ceiling.getKey());
                end = Math.max(end, ceiling.getValue());
                ceiling = treemap.ceilingEntry(start);
            }
            
            // System.out.println((p[1] - p[0]) - repeat);
            result[idx++] = (p[1] - p[0]) - repeat;
            
            treemap.put(start, end);
        }
        
        
        
        return result;
    }
}