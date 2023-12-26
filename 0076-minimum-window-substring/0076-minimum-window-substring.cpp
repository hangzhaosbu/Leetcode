class Solution {
public:
    unordered_map<char, int> map;
    string minWindow(string s, string t) {
        if(s.length() < t.length()) return "";
        int count = 0;
        
        for(auto& c : t)
        {
            map[c]++;
            count++;
        }
        
        int i = 0, j = 0, N = s.length();
        int ans = INT_MAX, start = 0, end = 0;
        
        while(i < N)
        {
            while(j < N && count > 0)
            {
                if(map.find(s[j]) != map.end())
                {
                    if(map[s[j]] > 0) count--;
                    map[s[j]]--;
                }
                j++;
            }
            
            if(j - i + 1 < ans && count == 0 && valid())
            {
                ans = j - i + 1;
                start = i;
                end = j;
            }
            
            
            if(map.find(s[i]) != map.end())
            {
                if(map[s[i]] >= 0)
                    count++;
                
                map[s[i]]++;
            }
            i++;
        }
        
        return s.substr(start, end - start);
    }
    
    bool valid()
    {
        for(auto& [key, val] : map)
        {
            if(val > 0) return false;
        }
        
        return true;
    }
};