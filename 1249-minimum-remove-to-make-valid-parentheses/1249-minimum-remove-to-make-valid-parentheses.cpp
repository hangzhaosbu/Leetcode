class Solution {
public:
    string filter(string s, char open, char close)
    {
        int balance = 0;
        string ans = "";
        
        
        for(auto& c : s)
        {
            if(c == open) balance++;
            else if(c == close)
            {
                if(balance <= 0) continue;
                balance--;
            }
            ans += c;
        }
        
        return ans;
    }
    string minRemoveToMakeValid(string s) {
        string result = filter(s, '(', ')');
        reverse(result.begin(), result.end());
        result = filter(result, ')', '(');
        reverse(result.begin(), result.end());
        return result;
    }
};