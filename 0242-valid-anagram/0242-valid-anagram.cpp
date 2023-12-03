class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char,int> map;
        
        for(auto& c : s)
        {
            map[c] = map[c] + 1;
        }
        
        for(auto& c : t)
        {
            if(map.find(c) == map.end()) return false;
            map[c] = map[c] - 1;
        }
        
        for(auto& [k,v] : map)
        {
            if(v!=0)return false;
        }
        return true;
    }
};