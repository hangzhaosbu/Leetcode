class Solution {
    
    private boolean match(String a, String b)
    {
        if(a.length() != b.length())
        {
            return false;
        }
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        
        
        int N = a.length();
        
        for(int i = 0; i < N; ++i)
        {
            Character c1 = a.charAt(i);
            Character c2 = b.charAt(i);
            
            if(!map1.containsKey(c1))
            {
                map1.put(c1,c2);
            }
            
            if(!map2.containsKey(c2))
            {
                map2.put(c2,c1);
            }
            
            if(map1.get(c1) != c2 || map2.get(c2) != c1)
            {
                return false;
            }
        }
        
        return true;
    }
    
    public List<String> findAndReplacePattern(String[] words, String pattern)
    {
        List<String> result = new ArrayList<>();
        
        for(String word : words)
        {
            if(match(word, pattern))
            {
                result.add(word);
            }
        }
        
        return result;
    }
}