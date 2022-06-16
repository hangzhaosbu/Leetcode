class Solution {
    
    private boolean valid(int[] char_s, int[] char_t)
    {
        for(int i = 0; i < 58; ++i)
        {
            if(char_t[i] > 0 && char_s[i] < char_t[i])
            {
                return false;
            }
        }
        
        return true;
    }
    
    public String minWindow(String s, String t)
    {
        int[] char_s = new int[58];
        int[] char_t = new int[58];
        int M = s.length(), N = t.length();
        
        for(int i = 0; i < N; ++i)
        {
            char_t[t.charAt(i) - 'A']++;
        }
        
        int j = 0, result = Integer.MAX_VALUE;
        int start = 0, end = 0;
        
        for(int i = 0; i < M; ++i)
        {
            while(j < M && !valid(char_s, char_t))
            {
                char_s[s.charAt(j) - 'A']++;
                j++;
            }
            
            if(valid(char_s, char_t))
            {
                result = Math.min(result, j - i);
                
                if(result == j - i)
                {
                    start = i;
                    end = j;
                }
            }
            
            char_s[s.charAt(i) - 'A']--;
        }
        
        return s.substring(start, end);
    }
}