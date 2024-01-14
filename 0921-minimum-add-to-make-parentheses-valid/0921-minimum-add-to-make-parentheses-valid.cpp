class Solution {
public:
    int minAddToMakeValid(string s) {
        int balance = 0;
        int ans = 0;
        
        for(auto& c : s)
        {
            balance += c == '(' ? 1: -1;
            
            if(balance == -1)
            {
                balance = 0;
                ans++;
            }
        }
        
        return ans + balance;
    }
};