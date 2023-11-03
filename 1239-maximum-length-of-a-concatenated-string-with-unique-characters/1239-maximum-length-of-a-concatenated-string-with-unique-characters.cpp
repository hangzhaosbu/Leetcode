class Solution {
public:
    int k = 1;
    int ans = 0;
    
    bool valid(vector<string>& strs)
    {
        int count[27] = {0};
        for(auto str : strs)
        {
            for(int i = 0; i < str.length(); i++) count[str[i] - 'a']++;
        }
        for(int i = 0; i < 27; i++) if(count[i] > 1) return false;
        return true;
    }
    
    int maxLength(vector<string>& arr) 
    {
        vector<bool> used(arr.size() + 1, false);
        vector<string> s;
        for(k = arr.size(); k >= 0; k--)
            dfs(0, s, 0, arr, used);
        return ans;
    }
    
    void dfs(int start, vector<string>& s, int len, vector<string>& arr, vector<bool>& used)
    {
        if(s.size() == k)
        {
            if(valid(s)) ans = max(ans, len);
            return;
        }
        
        for(int i = start; i < arr.size(); i++)
        {
            if(used[i]) continue;
            
            s.push_back(arr[i]);
            used[i] = true;
            dfs(i + 1, s, len + arr[i].length(), arr, used);
            used[i] = false;
            s.pop_back();
        }
    }
};