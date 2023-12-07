class Solution {
public:
    string largestOddNumber(string num) {
        int t = -1;
        
        for(int i = 0; i < num.length(); i++)
        {
            if((num[i] - '0') % 2 == 1) t = i;
        }
        
        return num.substr(0, t+1);
    }
};