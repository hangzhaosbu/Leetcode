class CountIntervals {
    
    TreeMap<Integer, Integer> treemap;
    int count;

    public CountIntervals() {
        treemap = new TreeMap<Integer, Integer>();
    }
    
    public void add(int left, int right) {
        int start = left, end = right;
        int toAdd = right - left + 1;
        
        Map.Entry<Integer, Integer> floor = treemap.floorEntry(left);
        if(floor != null){
            if(floor.getValue() >= end){
                return;
            }
            
            if(floor.getValue() >= start){
                toAdd -= floor.getValue() - start + 1;
                treemap.remove(floor.getKey());
                start = floor.getKey();
            }
        }
        
        
        Map.Entry<Integer, Integer> ceiling = treemap.ceilingEntry(left);
        while(ceiling != null && ceiling.getKey() <= end){
            toAdd -= Math.min(end, ceiling.getValue()) - ceiling.getKey() + 1;
            treemap.remove(ceiling.getKey());
            
            end = Math.max(end, ceiling.getValue());
            ceiling = treemap.ceilingEntry(left);
        }
        
        
        count += toAdd;
        treemap.put(start, end);
    }
    
    public int count() {
        return count;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */