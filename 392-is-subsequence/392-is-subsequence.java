class Solution {
    public boolean isSubsequence(String s, String t)
    {
        int ps = 0, pt = 0;
        
        while(pt < t.length())
        {
            if(ps < s.length() && pt < t.length() && s.charAt(ps) == t.charAt(pt))
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