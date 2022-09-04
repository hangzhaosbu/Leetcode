class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget)
    {
        int left = 0, right = 0, N = chargeTimes.length;
        Deque<Integer> deque = new ArrayDeque<>();
        long curt = 0;
        
        while(right < N)
        {
            while(!deque.isEmpty() && chargeTimes[deque.getLast()] < chargeTimes[right])
            {
                deque.pollLast();
            }
            
            curt += runningCosts[right];
            deque.add(right);
            right ++;
            
            
            if(!deque.isEmpty() && (right - left) * curt + chargeTimes[deque.getFirst()] > budget){
                curt -= runningCosts[left];
                
                if(chargeTimes[left] == chargeTimes[deque.getFirst()])
                {
                    deque.pollFirst();
                }
                
                left++;
            }
        }
        
        return N - left;
    }
}