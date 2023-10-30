class Solution {
public:
    bool isPalindrome(string s)
    {
        int l = 0, r = s.length() - 1;
        while(l < r)
        {
            if(s[l] == s[r])
            {
                l++;
                r--;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    
    void dfs(int start, int size, string s, vector<string>& result, vector<vector<string>>& results)
    {
        if(start == size)
        {
            results.push_back(result);
            return;
        }
        
        for(int i = start; i < size; i++)
        {
            if(isPalindrome(s.substr(start, i - start + 1)))
            {
                result.push_back(s.substr(start, i - start + 1));
                dfs(i + 1, size, s, result, results);
                result.pop_back();
            }
        }
        
    }
    vector<vector<string>> partition(string s) {
        vector<vector<string>> results;
        vector<string> result;
        int size = s.length();
        dfs(0, size, s, result, results);
        
        return results;
    }
};