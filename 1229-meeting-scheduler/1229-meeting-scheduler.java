class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        TreeMap<Integer, Integer> treemap = new TreeMap<Integer, Integer>();
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < slots1.length; i++)
        {
            int start = slots1[i][0];
            int end = slots1[i][1];
            
            treemap.put(start, end);
        }
        
        
        Arrays.sort(slots2, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        
        for(int i = 0; i < slots2.length; i++)
        {
            /*
                      |   |
                     |   |
            */      
            int start = slots2[i][0];
            int end = slots2[i][1];
            
            
            Map.Entry<Integer, Integer> start_floor = treemap.floorEntry(start);
            if(result.size() == 0 && start_floor != null && Math.min(end, start_floor.getValue()) - Math.max(start, start_floor.getKey()) >= duration)
            {
                result.add(Math.max(start, start_floor.getKey()));
                result.add(Math.max(start, start_floor.getKey()) + duration);
                break;
            }
            
            
            Map.Entry<Integer, Integer> start_ceiling = treemap.ceilingEntry(start);
            if(result.size() == 0 && start_ceiling != null && Math.min(end, start_ceiling.getValue()) - Math.max(start, start_ceiling.getKey()) >= duration)
            {
                result.add(Math.max(start, start_ceiling.getKey()));
                result.add(Math.max(start, start_ceiling.getKey()) + duration);
                break;
            }
            
            Map.Entry<Integer, Integer> end_floor = treemap.floorEntry(end);
            if(result.size() == 0 && end_floor != null && Math.min(end, end_floor.getValue()) - Math.max(start, end_floor.getKey()) >= duration)
            {
                result.add(Math.max(start, end_floor.getKey()));
                result.add(Math.max(start, end_floor.getKey()) + duration);
                break;
            }
        }
        
        return result;
    }
}