class Solution {
public:
    string minRemoveToMakeValid(string s) {
        unordered_set<int> set;
        stack<int> st;
        
        for(int i = 0; i < s.length(); i++)
        {
            char c = s[i];
            
            if(c == '(')
            {
                st.push(i);
            }
            else if(c == ')')
            {
                if(st.empty())
                {
                    set.insert(i);
                }
                else
                {
                    st.pop();
                }
            }
        }
        
        while(!st.empty()) 
        {
            int top = st.top();
            st.pop();
            
            set.insert(top);
        }
        
        string ans = "";
        
        for(int i = 0; i < s.length(); i++)
        {
            if(set.find(i) == set.end())
            {
                ans += s[i];
            }
        }
        
        return ans;
    }
};