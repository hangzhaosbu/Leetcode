using namespace std;

class Solution {
public:
    bool valid(string s)
    {
        // cout << s << endl;
        if(s.size() == 0 || s.size() > 3 || (s.size() > 1 && s[0] == '0')) return false;
        if(stoi(s) < 0 || stoi(s) > 255) return false;
        return true;
    }
    
    void dfs(int start, int dots, int size, const string& s, string curt, vector<string>& results)
    {
        if(start == size && dots == 4)
        {
            results.push_back(curt.substr(0, curt.length() - 1));
            return;
        }
        
        for(int i = start; i < size; i++)
        {
            if(valid(s.substr(start, i - start + 1)))
            {
                curt += s.substr(start, i - start + 1) + ".";
                dfs(i + 1, dots + 1, size, s, curt, results);
                curt = curt.substr(0, curt.length() - (i - start + 2));
            }
        }
    }
    
    vector<string> restoreIpAddresses(string s) {
        vector<string> results;
        int size = s.length();
        
        dfs(0, 0, size, s, "", results);
        
        return results;
    }
};