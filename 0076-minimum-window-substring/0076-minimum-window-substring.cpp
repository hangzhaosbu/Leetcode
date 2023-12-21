class Solution {
public:
    int countS[256];
    int countT[256];
    string minWindow(string s, string t) {
        for(auto& c : t)
        {
            countT[(int) c]++;
        }
        
        int i = 0, j = 0, N = s.length();
        int ans = INT_MAX, start = 0, end = 0;
        
        while(i < N)
        {
            while(j < N && !valid())
            {
                countS[(int) s[j]]++;
                j++;
            }
            
            if(j - i + 1 < ans && valid())
            {
                ans = j - i + 1;
                start = i;
                end = j;
            }
            
            countS[(int) s[i]]--;
            i++;
        }
        
        return s.substr(start, end - start);
    }
    
    bool valid()
    {
        for(int i = 0; i < 256; i++)
        {
            if(countS[i] < countT[i]) return false;
        }
        
        return true;
    }
};