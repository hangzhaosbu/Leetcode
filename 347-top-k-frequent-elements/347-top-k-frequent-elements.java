class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int[] result = new int[k];
        int p = 0;
        
        for(Integer num : nums)
        {
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));
        
        for(int key : hashmap.keySet())
        {
            pq.offer(new int[]{hashmap.get(key), key});
            
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        
        while(pq.size() != 0)
        {
            result[p++] = pq.peek()[1];
            pq.poll();
        }
        
        return result;
    }
}