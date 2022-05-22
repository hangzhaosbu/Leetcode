class Solution {
    
    int start = 0, end = 0, max_len = 0;
    
    private void help(int left, int right, int N, String s)
    {
        if(left < 0 || right > N - 1)
        {
            return;
        }
        
        while(left > -1 && right < N && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }
        
        if(right - 1 - (left + 1) > max_len)
        {
            max_len = right - 1 - (left + 1);
            start = left + 1;
            end = right - 1;
        }
    }
    
    public String longestPalindrome(String s)
    {
        int N = s.length();
        
        for(int i = 0; i < N; ++i)
        {
            help(i, i, N, s);
            help(i, i + 1, N, s);
        }
        
        return s.substring(start, end + 1);
    }
}