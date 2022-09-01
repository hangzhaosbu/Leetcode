class Solution {
    public boolean isSubsequence(String s, String t)
    {
        int ps = 0, pt = 0;
        
        while(ps < s.length())
        {
            
            if(pt >= t.length())
            {
                break;
            }
            
            if(s.charAt(ps) == t.charAt(pt))
            {
                ps++;
                pt++;
            }
            
            else
            {
                pt++;
            }
        }
        
        return ps == s.length();
    }
}