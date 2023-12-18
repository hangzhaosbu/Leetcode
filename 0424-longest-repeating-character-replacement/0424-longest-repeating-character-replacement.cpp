class Solution {
public:
    int chars[26];
    int characterReplacement(string s, int k) {
        int i = 0, j = 0, N = s.length(), ans = 0, maxfreq = 0;
        
        while(i < N)
        {
            chars[s[i] - 'A']++;
            
            maxfreq = max(maxfreq, chars[s[i] - 'A']);
            
            bool valid = (i - j + 1 - maxfreq <= k);
            
            if(!valid)
            {
                chars[s[j] - 'A']--;
                j++;
            }
            
            ans = max(ans, i - j + 1);
            i++;
        }
        
        return ans;
    }
};