class Solution {
    public boolean isAnagram(String s, String t) {
        int N = s.length(), M = t.length();
        
        if(N != M)
        {
            return false;
        }
        
        int[] letter_s = new int[26];
        int[] letter_t = new int[26];
        
        for(int i = 0; i < N; ++i)
        {
            letter_s[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < M; ++i)
        {
            letter_t[t.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; ++i)
        {
            if(letter_s[i] != letter_t[i])
            {
                return false;
            }
        }
        
        return true;
    }
}