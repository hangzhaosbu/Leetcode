class Solution {
    public int longestPalindrome(String s)
    {
        int[] count = new int[256];
        int result = 0;
        boolean mid = false;
        
        for(int i = 0; i < s.length(); ++i)
        {
            count[s.charAt(i)]++;
        }
        
        for(int i = 0; i < 256; ++i)
        {
            if(count[i] >= 2)
            {
                result += (count[i]/2) * 2;
                count[i] %= 2;
            }
            
            if(count[i] == 1)
            {
                mid = true;
            }
        }
        
        
        if(mid == true)
        {
            result++;
        }
        
        return result;
    }
}