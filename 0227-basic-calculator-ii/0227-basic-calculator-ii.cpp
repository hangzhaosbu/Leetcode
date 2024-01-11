class Solution {
public:
    int calculate(string s) {
        char sign = '+';
        int currentNum = 0, prevNum = 0;
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
                    ans += prevNum;
                    prevNum = sign == '+' ? currentNum : -currentNum;
                }
                else if(sign == '*')
                {
                    prevNum = prevNum * currentNum;
                }
                else
                {
                    prevNum = prevNum / currentNum;
                }
                
                
                sign = currentChar;
                currentNum = 0;
            }
        }
        
        //3+2*2
        ans += prevNum;
        return ans;
    }
};