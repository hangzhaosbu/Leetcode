class SummaryRanges {
    TreeMap<Integer, Integer> treemap;

    public SummaryRanges() {
        treemap = new TreeMap<Integer, Integer>();
    }
    
    public void addNum(int val) {
        int start = val, end = val;
        
        Map.Entry<Integer, Integer> floor = treemap.floorEntry(val);
        if(floor != null)
        {
            if(floor.getValue() >= end){
                return;
            }
            else if(floor.getValue() >= start)
            {
                treemap.remove(floor.getKey());
                start = Math.min(start, floor.getKey());
            }
            else if(floor.getValue() + 1 == start)
            {
                treemap.remove(floor.getKey());
                start = Math.min(start, floor.getKey());
                end = Math.max(end, floor.getValue());
            }
        }
        
        Map.Entry<Integer, Integer> ceiling = treemap.ceilingEntry(val);
        
        while(ceiling != null && ceiling.getKey() <= end)
        {
            treemap.remove(ceiling.getKey());
            end = Math.max(end, ceiling.getValue());
            ceiling = treemap.ceilingEntry(val);
        }
        
        if(ceiling != null && ceiling.getKey() == end + 1){
            treemap.remove(ceiling.getKey());
            start = Math.min(start, ceiling.getKey());
            end = Math.max(end, ceiling.getValue());
        }
        
        treemap.put(start, end);
    }
    
    public int[][] getIntervals() {
        int size = treemap.size();
        int[][] result = new int[size][2];
        int p = 0;
        
        for(Map.Entry<Integer, Integer> entry : treemap.entrySet())
        {
            result[p][0] = entry.getKey();
            result[p][1] = entry.getValue();
            p ++;
        }
        
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */