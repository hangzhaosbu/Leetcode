class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> results;
        
        unordered_map<string, vector<string>> map;
        
        for(auto& str : strs)
        {
            string original = str;
            sort(str.begin(), str.end());
            map[str].push_back(original);
        }
        
        for(auto const& [k,v] : map)
        {
            results.push_back(v);
        }
        
        return results;
    }
};