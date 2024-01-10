class Solution {
public:
    bool validWordAbbreviation(string word, string abbr) {
        int i = 0, j = 0;
        int n = word.length(), m = abbr.length();
        
        while(i < n)
        {
            if(word[i] == abbr[j])
            {
                i++;
                j++;
            }
            
            else if(abbr[j] >= '0' && abbr[j] <= '9')
                
            {
                int t = j + 1;
                while(t < m && abbr[t] >= '0' && abbr[t] <= '9')
                {
                    t++;
                }
                
                if(t != j && abbr[j] == '0') return false;
                
                int num = stoi(abbr.substr(j, t - j));
                i += num;
                j = t;
            }
            else
            {
                return false;
            }
        }
        
        return i == n && j == m;
    }
};