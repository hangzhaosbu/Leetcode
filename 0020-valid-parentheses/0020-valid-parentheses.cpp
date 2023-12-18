class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        
        for(auto& c : s)
        {
            if(c == '(' || c == '[' || c == '{')
            {
                st.push(c);
            }
            else
            {
                if(st.size() == 0) return false;
                char top = st.top();
                
                if(c == ')' && top == '(') st.pop();
                else if(c == ']' && top == '[') st.pop();
                else if(c == '}' && top == '{') st.pop();
                
                else return false;
            }
        }
        
        return st.empty();
    }
};