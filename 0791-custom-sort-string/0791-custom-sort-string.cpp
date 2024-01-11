class Solution {
public:
    string customSortString(string order, string s) {
        unordered_map<char,int> map;
        string ans = "";
        
        for(auto& c : s)
        {
            map[c]++;
        }
        
        for(auto& c: order)
        {
            if(map.find(c) != map.end())
            {
                int count = map[c];
                
                
                while(count--)
                {
                    ans += c;
                    map[c]--;
                }
                    
                
            }
                
        }
        
        for(int c = 'a'; c <= 'z'; c++)
        {
            if(map[c] > 0)
            {
                while(map[c]--)
                {
                    ans += c;
                }
            }
        }
        
        return ans;
    }
};