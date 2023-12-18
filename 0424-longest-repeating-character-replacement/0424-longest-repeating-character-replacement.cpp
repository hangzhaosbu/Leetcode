class Solution {
public:
    int characterReplacement(string s, int k) {
        int ans = 0;
        int N = s.length();
        
        for(char c = 'A'; c <= 'Z'; c++)
        {
            int i = 0, j = 0;
            
            while(i < N)
            {
                while(j < N && (s[j] == c || s[j] != c && k > 0))
                {
                    k -= s[j] != c;
                    j++;
                }
                
                ans = max(ans, j - i);
                
                k += s[i] != c;
                i++;
            }
        }
        
        return ans;
    }
};