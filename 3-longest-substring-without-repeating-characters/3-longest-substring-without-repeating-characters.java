class Solution {
    public int lengthOfLongestSubstring(String s)
    {
        HashSet<Character> hashset = new HashSet<>();
        int N = s.length(), j = -1, result = 0;
        
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