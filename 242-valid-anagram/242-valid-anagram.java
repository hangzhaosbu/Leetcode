class Solution {
    public boolean isAnagram(String s, String t) 
    {
        if(s.length() != t.length())
        {
            return false;
        }
        
        int[] letter = new int[26];
        
        for(int i = 0; i < s.length(); ++i)
        {
            Character c = s.charAt(i);
            letter[c - 'a']++;
        }
        
        
        for(int i = 0; i < t.length(); ++i)
        {
            Character c = t.charAt(i);
            if(letter[c - 'a'] == 0)
            {
                return false;
            }
            
            letter[c - 'a']--;
        }
        
        return true;
    }
}