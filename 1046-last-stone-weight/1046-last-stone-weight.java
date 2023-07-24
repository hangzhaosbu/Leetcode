class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer num1, Integer num2){
                return num2 - num1;
            }
        });
        
        for(int stone : stones) pq.offer(stone);
        
        while(pq.size() >= 2)
        {
            int first = pq.poll().intValue();
            int second = pq.poll().intValue();
            
            if(first != second)
            {
                pq.offer(first - second);
            }
        }
        
        if(pq.size() == 0) return 0;
        return (int) pq.peek();
    }
}