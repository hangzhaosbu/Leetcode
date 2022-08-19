class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int result = 0;
        
        for(int i = 0; i < time.length; ++i)
        {
            int r = time[i] % 60;
            
            if(r == 0)
            {
                result+=remainders[0];
            }
            else
            {
                result+=remainders[60 - r];
            }
            
            remainders[r]++;
        }
        
        return result;
    }
}