class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        if(s.length() == 0)
        {
            return 0;
        }
        int result = 0, j = 0, N = s.length();
        HashSet<Character> hashset = new HashSet<>();
        hashset.add(s.charAt(0));
        
        for(int i = 0; i < N; ++i)
        {
            while(j + 1 < N && !hashset.contains(s.charAt(j + 1)))
            {
                hashset.add(s.charAt(j + 1));
                j++;
            }
            
            result = Math.max(result, j - i + 1);
            hashset.remove(s.charAt(i));
        }
        
        return result;
    }
}