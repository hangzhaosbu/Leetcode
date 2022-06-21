public class Solution {
    // you need to treat n as an unsigned value
    
    private int calbits(int n)
    {
        int count = 0;
        while(n > 0)
        {
            count += (n&1);
            n /= 2;
        }
        return count;
    }
    public int hammingWeight(int n) {
        int count = 0;
        
        if(n < 0)
        {
            n = ~n;
            return 32 - calbits(n);
        }
        
        return calbits(n);
    }
}