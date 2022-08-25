class Solution {
    public int numPairsDivisibleBy60(int[] time)
    {
        int[] count = new int[60];
        int result = 0;
        
        for(int i = 0; i < time.length; i++)
        {
            int r = time[i] % 60;
            
            if(r == 0)
            {
                result += count[0];
            }
            else
            {
                result += count[60 - r];
            }
            
            count[r] ++;
        }
        
        return result;
    }
}