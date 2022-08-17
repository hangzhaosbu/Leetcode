class Solution {
    public int uniqueMorseRepresentations(String[] words)
    {
        String[] code = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        HashSet<String> hashset = new HashSet<>();
        for(int i = 0; i < words.length; ++i)
        {
            StringBuilder s = new StringBuilder();
            
            for(int j = 0; j < words[i].length(); ++j)
            {
                s.append(code[words[i].charAt(j) - 'a']);
            }
            
            if(!hashset.contains(s.toString()))
            {
                hashset.add(s.toString());
            }
        }
        
        return hashset.size();
        
    }
}