public class Solution {
    // you need to treat n as an unsigned value
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int hammingWeight(int n) {
        
        if(map.containsKey(n))
        {
            return map.get(n);
        }
        
        int mask = (1 << 31) - 1;
        int count = 0;
        
        if(n < 0)
        {
            count++;
            n = n & mask;
        }
        
        while(n > 0)
        {
            count += n & 1;
            n = n >> 1;
        }
        
        map.put(n, count);
        return count;
    }
}