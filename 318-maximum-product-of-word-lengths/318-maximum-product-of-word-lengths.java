class Solution {
    
    private boolean valid(int i, int j, HashSet<Character>[] s)
    {
        for(Character c : s[i])
        {
            if(s[j].contains(c))
            {
                return false;
            }
        }
        
        return true;
    }
    
    public int maxProduct(String[] words)
    {
        int N = words.length;
        int result = 0;
        
        HashSet<Character>[] s = new HashSet[N];
        
        
        for(int i = 0; i < N; ++i)
        {
            
            s[i] = new HashSet<>();
            for(int j = 0; j < words[i].length(); ++j)
            {
                s[i].add(words[i].charAt(j));
            }
        }
        
        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < N; ++j)
            {
                if(i == j)
                {
                    continue;
                }
                
                
                if(valid(i, j, s))
                {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        
        return result;
    }
}