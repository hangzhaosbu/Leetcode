class Solution {
    public int characterReplacement(String s, int k) {
        int N = s.length();
        int result = 0;
        
        for(int p = 'A'; p <= 'Z'; ++p)
        {
            int j = -1;
            int count = k;
            for(int i = 0; i < N; ++i)
            {
                while(j + 1 < N && (s.charAt(j + 1) == p || (s.charAt(j + 1) != p && count > 0)))
                {
                    count -= s.charAt(j + 1) == p ? 0 : 1;
                    j++;
                }
                
                result = Math.max(result, j - i + 1);
                count += s.charAt(i) == p ? 0 : 1;
            }
        }
        
        return result;
    }
}