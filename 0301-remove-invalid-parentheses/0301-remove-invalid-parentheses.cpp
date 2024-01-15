class Solution {
public:
    bool valid(string s)
    {
        int balance = 0;
        for(auto& c : s)
        {
            if(c == '(') balance++;
            else if(c == ')') balance--;
            
            if(balance < 0) return false;
        }
        
        return balance == 0;
    }
    
    void recur(int start, int l, int r, string s, vector<string>& ans)
    {
        if(l == 0 && r == 0)
        {
            if(valid(s))
            {
                ans.push_back(s);
            }
            
            return;
        }
        
        
        for(int i = start; i < s.length(); i++)
        {
            if(i != start && s[i] == s[i - 1]) continue;
            
            if(s[i] == '(' || s[i] == ')')
            {
                string news = s.substr(0, i) + s.substr(i + 1, s.length() - (i + 1));
            
                if(s[i] == '(' && l > 0)
                    recur(i, l - 1, r, news, ans);
                else if(s[i] == ')' && r > 0)
                    recur(i, l, r - 1, news, ans);
            }
        }
    }
    
    vector<string> removeInvalidParentheses(string s)
    {
        int l = 0, r = 0;
        
        for(auto& c : s)
        {
            if(c == '(') l++;
            
            if(c == ')')
            {
                if(l == 0) r++;
                else l--;
            }
        }
        
        vector<string> ans;
        
        recur(0, l, r, s, ans);
        return ans;
    }
};