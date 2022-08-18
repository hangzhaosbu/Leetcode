class Solution {
    public int countBinarySubstrings(String s) {
        // 2 2 2 2
        // 1 1 1 1 1
        
        int[] count = new int[s.length()];
        int i = 0, p = 0, result = 0;
        
        while(i < s.length())
        {
            int j = i + 1;
            
            while(j < s.length() && s.charAt(j) == s.charAt(i))
            {
                j++;
            }
            
            count[p++] = j - i;
            i = j;
        }
        
        
        for(int j = 1; j < s.length(); ++j)
        {
            if(count[j] == 0) break;
            result += Math.min(count[j], count[j - 1]);
        }
        
        return result;
    }
}