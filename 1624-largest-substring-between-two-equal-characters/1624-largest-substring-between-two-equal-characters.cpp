class Solution {
public:
    int maxLengthBetweenEqualCharacters(string s) {
        vector<int> first(26, -1);
        vector<int> last(26, -1);
        int ans = -1;
        
        for(int i = 0; i < s.length(); i++)
        {
            char c = s[i];
            if(first[c - 'a'] == -1)
            {
                first[c - 'a'] = i;
            }
            
            last[c - 'a'] = i;
        }
        
        
        for(int i = 0; i < 26; i++)
        {
            if(first[i] != -1 && last[i] != - 1 && first[i] != last[i])
            {
                ans = max(ans, last[i] - first[i] - 1);
            }
            // cout << first[i] << ", " << last[i] << endl;
        }
        
        return ans;
    }
};