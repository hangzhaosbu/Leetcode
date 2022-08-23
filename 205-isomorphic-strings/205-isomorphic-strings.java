class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hashmap1 = new HashMap<>();
        HashMap<Character, Character> hashmap2 = new HashMap<>();
        
        for(int i = 0; i < s.length(); ++i)
        {
            if(!hashmap1.containsKey(s.charAt(i)) && !hashmap2.containsKey(t.charAt(i)))
            {
                hashmap1.put(s.charAt(i), t.charAt(i));
                hashmap2.put(t.charAt(i), s.charAt(i));
            }
            else
            {
                
                if(!hashmap1.containsKey(s.charAt(i)) || !hashmap2.containsKey(t.charAt(i)))
                {
                    return false;
                }
                
                if(hashmap1.get(s.charAt(i)) != t.charAt(i) || hashmap2.get(t.charAt(i)) != s.charAt(i))
                {
                    return false;
                }
                
                
            }
        }
        
        return true;
    }
}