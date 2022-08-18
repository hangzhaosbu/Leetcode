class Solution {
    public int numPairsDivisibleBy60(int[] time)
    {
        
        // 2147483647, 
        // 1799970000
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int[] sixties = new int[16];
        long result = 0;
        
        for(int i = 0; i < 16; ++i)
        {
            sixties[i] = (i + 1) * 60;
        }
        
        for(int i = 0; i < time.length; ++i)
        {
            hashmap.put(time[i], hashmap.getOrDefault(time[i], 0) + 1);
        }
        
        for(int i = 0; i < time.length; ++i)
        {
            for(int j = 0; j < 16; ++j)
            {
                if(sixties[j] - time[i] >= 0 && hashmap.containsKey(sixties[j] - time[i]))
                {
                    result += hashmap.get(sixties[j] - time[i]);
                    
                    if(sixties[j] - time[i] == time[i])
                    {
                        result--;
                    }
                }
                
            }
        }
        
        return (int) (result/2);
    }
}