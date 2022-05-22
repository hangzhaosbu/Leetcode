class Solution {
    int count = 0;
    
    private void help(int left, int right, int N, String s)
    {
        if(left < 0 || right > N - 1)
        {
            return;
        }
        
        while(left > -1 && right < N && s.charAt(left) == s.charAt(right))
        {
            count ++;
            left --;
            right ++;
        }
    }
    public int countSubstrings(String s)
    {
        int N = s.length();
        
        for(int i = 0; i < N; ++i)
        {
            help(i, i, N, s);
            help(i, i + 1, N, s);
        }
        
        return count;
    }
}