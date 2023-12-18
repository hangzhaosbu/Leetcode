class Solution {
public:
    int chars[256];
    int lengthOfLongestSubstring(string s) {
        
        int i = 0, j = 0, N = s.length();
        int ans = 0;
        
        while(i < N)
        {
            while(j < N && chars[(int) s[j]] == 0)
            {
                chars[(int) s[j]]++;
                j++;
            }
            
            ans = max(ans, j - i);
            
            chars[(int) s[i]]--;
            i++;
        }
        
        return ans;
        
    }
};