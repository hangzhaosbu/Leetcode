class Solution {
public:
    string buttons[10] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    vector<string> letterCombinations(string digits)
    {
        vector<string> result;
        dfs(0, "", digits, result);
        
        return result;
    }
    
    void dfs(int start, string s, string digits, vector<string>& result)
    {
        if(start == digits.length() && s.length() == digits.length() && s.length() != 0)
        {
            result.push_back(s);
            return;
        }
        
        for(int i = start; i < digits.length(); i++)
        {
            int j = stoi(digits.substr(i, 1));
            string button = buttons[j];
            
            for(auto c : button)
            {
                dfs(i + 1, s + c, digits, result);
            }
        }
    }
};