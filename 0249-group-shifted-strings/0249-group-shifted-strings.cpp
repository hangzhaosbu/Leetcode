class Solution {
public:
    vector<vector<string>> groupStrings(vector<string>& strings) {
        unordered_map<string, vector<string>> map;
        vector<vector<string>> ans;
        
        for(auto& str : strings)
        {
            if(str[0] == 'a')
            {
                map[str].push_back(str);
            }
            else
            {
                int diff = str[0] - 'a';
                
                string news = "";
                
                
                for(int i = 0; i < str.length(); i++)
                {
                    char c = str[i];
                    char newc;
                    if((int) c - diff >= 97)
                        newc = (char) (((int) c - diff) % 123);
                    else
                        newc = (char) (((int) c - diff + 26) % 123);
                    string s(1, newc);
                    news += s;
                }
                
                map[news].push_back(str);
            }
        }
        
        for(auto& [key, value] : map)
        {
            ans.push_back(value);
//             cout << key << " ";
            
//             for(auto v : value)
//                 cout<< v << " ";
//             cout<<endl;
        }
        
        return ans;
    }
};