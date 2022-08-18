class Solution {
    public int numPairsDivisibleBy60(int[] time)
    {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        
        long result = 0;
        for(int i = 0; i < time.length; ++i)
        {
            hashmap.put(time[i], hashmap.getOrDefault(time[i], 0) + 1);
        }
        
        for(int i = 0; i < time.length; ++i)
        {
            for(int j = 0; j < 16; ++j)
            {
                int curt = (j + 1) * 60;
                if(curt - time[i] >= 0 && hashmap.containsKey(curt - time[i]))
                {
                    result += hashmap.get(curt - time[i]);
                    
                    if(curt - time[i] == time[i])
                    {
                        result--;
                    }
                }
            }
        }
        
        return (int) (result/2);
    }
}