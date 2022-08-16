class Solution {
    public int firstUniqChar(String s)
    {
        int[] pos = new int[26];
        
        for(int i = 0; i < s.length(); ++i)
        {
            pos[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s.length(); ++i)
        {
            if(pos[s.charAt(i) - 'a'] == 1)
            {
                return i;
            }
        }
        
        return -1;
    }
}