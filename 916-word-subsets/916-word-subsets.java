class Solution {
    
    private boolean valid(int[] curr, int[] hashset)
    {
        for(int i = 0; i < 26; i++)
        {
            if(curr[i] < hashset[i])
            {
                return false;
            }
        }
        
        return true;
    }
    
    public List<String> wordSubsets(String[] words1, String[] words2)
    {
        List<String> result = new ArrayList<>();
        int[] hashset = new int[26];
        
        for(String word : words2)
        {
            int[] curr = new int[26];
            for(int i = 0; i < word.length(); ++i)
            {
                curr[word.charAt(i) - 'a']++;
                hashset[word.charAt(i) - 'a'] = Math.max(hashset[word.charAt(i) - 'a'], curr[word.charAt(i) - 'a']);
            }
        }
        
        for(String word : words1)
        {
            int[] curr = new int[26];
            
            for(int i = 0; i < word.length(); ++i)
            {
                curr[word.charAt(i) - 'a']++;
            }
            
            if(valid(curr, hashset))
            {
                result.add(word);
            }
        }
        
        return result;
    }
}