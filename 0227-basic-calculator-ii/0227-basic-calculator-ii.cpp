class Solution {
public:
    int calculate(string s) {
        stack<int> st;
        char sign = '+';
        int currentNum = 0;
        int ans = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            char currentChar = s[i];
            
            if(currentChar >= '0' && currentChar <= '9')
            {
                currentNum = currentNum * 10 + (currentChar - '0');
            }
            
            if(!(currentChar >= '0' && currentChar <= '9') && currentChar != ' ' || i == s.length() - 1)
            {
                if(sign == '+' || sign == '-')
                {
                    st.push(sign == '+' ? currentNum : -currentNum);
                }
                else if(sign == '*')
                {
                    int top = st.top();
                    st.pop();
                    st.push(top * currentNum);
                }
                else
                {
                    int top = st.top();
                    st.pop();
                    st.push(top / currentNum);
                }
                
                
                sign = currentChar;
                currentNum = 0;
            }
        }
        
        while(!st.empty())
        {
            int top = st.top();
            st.pop();
            ans += top;
        }
        
        return ans;
    }
};