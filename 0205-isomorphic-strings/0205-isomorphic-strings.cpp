class Solution {
public:
    bool isIsomorphic(string s, string t) {
        unordered_map<char, char> map1;
        unordered_map<char, char> map2;
        
        for(int i = 0; i < s.length(); i++)
        {
            if(map1.find(s[i]) == map1.end())
            {
                map1[s[i]] = t[i];
            }
            else
            {
                if(map1[s[i]] != t[i]) return false;
                
            }

            if(map2.find(t[i]) == map2.end())
            {
                map2[t[i]] = s[i];
            }
            else
            {
                if(map2[t[i]] != s[i]) return false;
                
            }
        }
        
        return true;
    }
};