class Solution {
public:
    int count = 0;
    int countSubstrings(string s) 
    {
        
        for(int i = 0; i < s.length(); i++)
        {
            helper(i, i, s);
            
            if(i < s.length() - 1)
            {
                helper(i, i + 1, s);
            }
        }
        
        return count;
    }
    
    void helper(int left, int right, string s)
    {
        while(left >= 0 && right < s.length())
        {
            if(s[left] == s[right])
            {
                count++;
                left--;
                right++;
            }
            else
            {
                break;
            }
        }
    }
};