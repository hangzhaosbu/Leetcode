class Solution {
public:
    int count = 1;
    bool validPalindrome(string s) {
        int l = 0, r = s.length() - 1;
        
        while(l < r)
        {
            if(s[l] == s[r])
            {
                l++;
                r--;
            }
            else if(count == 0)
            {
                return false;
            }
            else
            {
                count--;
                return validPalindrome(s.substr(l + 1, r - l)) || validPalindrome(s.substr(l, r - l));
            }
        }
        
        return true;
    }
};